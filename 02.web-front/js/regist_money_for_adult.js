var isMock = false;
var userData;
var workId;
var workDetail;
$(function(){
    windowLoad();
    init();
    displayWorkDetail();
    displayButton();
    displayHanamaru();
});

function windowLoad() {
    console.log("load");
}

function init() {
    userData = JSON.parse(sessionStorage.getItem("userData"));
    var params = document.location.search.substring(1).split('&');
    var element = params[0].split('=');
    workId = decodeURIComponent(element[1]);
    console.log("userData=" + JSON.stringify(userData));
    console.log("workId=" + workId);
    
    var workList = userData.workList;
    for (var i in workList) {
        if (workList[i].work_id == workId) {
            workDetail = workList[i];
            break;
        }
    }
}

function displayWorkDetail() {
    $("#workName").html(workDetail.work_item_name);
    $("#nedan").html(toNedan(workDetail.currency_id, workDetail.number));
    $("#discription").html(workDetail.child_comment);
}

function displayHanamaru() {
    if (workDetail.approval == 1) {
        document.getElementById("hanamaru").innerHTML = "<img src ='img/hanamaru.jpg'>";
    }
}

function toNedan(currency_id, number) {

    var currency;
    switch (currency_id) {
        case "gold":
            currency = "ごーるど";
            break;
        case "silver":
            currency = "しるばー";
            break;
        default:
            currency = "ぶろんず";
    }
    return number + currency;
}

function displayButton() {

    if (workDetail.approval != 0 || !userData.isParent ) {
        $("#rejection").hide();
        $("#apply").hide();
    } else {
        $("#back").hide();
    }
}

function update(approval) {

    if(isMock) {
        location.href='main.html';
    }

    var time = getTime();
    //var userId = getUserId();
    //var workItem = document.getElementById("workName").value;
    //var comment = document.getElementById("discription").value;
    var requestData = {
        work_id: workDetail.work_id,
        pay_date : time,
        user_id : workDetail.user_id,
        work_item_id : workDetail.work_item_id,
        child_comment : workDetail.child_comment,
        attached_image : null,
        parent_comment_id : null,
        approval : approval
    };

    console.log("requestData=" + JSON.stringify(requestData));
    $.ajax({
        type:"post",                // method = "POST"
        url:"http://40.74.73.197:8080/api/spajam/if20180003",        // POST送信先のURL
        data:JSON.stringify(requestData),  // JSONデータ本体
        contentType: 'application/json', // リクエストの Content-Type
        //dataType: "json",           // レスポンスをJSONとしてパースする
        async: false,
        success: function() {   // 200 OK時
            location.href='main.html';
        },
        error: function() {         // HTTPエラー時
            $("#errorMsg").show();
        },
    });

}

function getTime() {
    var today = new Date();
    var time = today.getFullYear() + "/" +
            ('0' + (today.getMonth() + 1)).slice(-2) + "/" +
            ('0' + today.getDate()).slice(-2) + " " +
            ('0' + today.getHours()).slice(-2) + ":" +
            ('0' + today.getMinutes()).slice(-2) + ":" +
            ('0' + today.getSeconds()).slice(-2);

    return time;
}

function getUserId() {
    var userId = sessionStorage.userId;
    console.log(userId);
    return  userId;
}

function back() {
    location.href='main.html';
}