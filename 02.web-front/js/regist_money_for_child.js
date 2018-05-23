var isMock = true;
var mockJson = {
    workItemList : [
            {
                work_item_id : 1,
                name : "テストで100てん",
                currency_id : "gold",
                number : 10
            },
            {
                work_item_id : 2,
                name : "まらそん１かい",
                currency_id : "silver",
                number : 1
            },
            {
                work_item_id : 3,
                name : "テストで90てん",
                currency_id : "gold",
                number : 5
            }
        ],
    };

$(function(){
    windowLoad();

    getWorkItemList();

    displayWorkItemList();
    displayNedan();
});

function windowLoad() {
    console.log("load");
}

function getWorkItemList() {

    if (isMock) {
        return;
    }

    $.ajax({
        type:"get",                // method = "POST"
        url:"localhost:8080/api/spajam/if20180001",        // POST送信先のURL
        contentType: 'application/json', // リクエストの Content-Type
        dataType: "json",           // レスポンスをJSONとしてパースする
        success: function(responseData) {   // 200 OK時
            jsonData = responseData;
        },
        error: function() {         // HTTPエラー時
            console.log("Server Error. Pleasy try again later.");
        },
        complete: function() {      // 成功・失敗に関わらず通信が終了した際の処理
            console.log("callAPi end");
        }
    });
}

function displayWorkItemList() {

    var workItemList;
    if (isMock) {
        workItemList = mockJson.workItemList;
    } else {
        workItemList = jsonData.workItemList;
    }

    var select = document.getElementById("workItemList");

    for (var i in workItemList) {
        var option_add = document.createElement("option");
        option_add.setAttribute("value", workItemList[i].work_item_id);
        option_add.innerHTML = workItemList[i].name;
        select.appendChild(option_add);
    }
}

function displayNedan() {
    var value = document.getElementById("workItemList").value;

    var workItemList;
    if (isMock) {
        workItemList = mockJson.workItemList;
    } else {
        workItemList = jsonData.workItemList;
    }

    var currency_id;
    var number;
    for (var i in workItemList) {
        if (workItemList[i].work_item_id == value) {
            currency_id = workItemList[i].currency_id;
            number = workItemList[i].number;
            break;
        }
    }

    $("#nedan").html(toNedan(currency_id, number));

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

function done() {

    if(isMock) {
        location.href='main.html';
    }
    
    var time = getTime();
    var userId = getUserId();
    var workItem = document.getElementById("workItemList").value;
    var comment = document.getElementById("discription").value;
    var requestData = {
        work_id: null,
        pay_date : time,
        user_id : userId,
        work_item_id : workItem,
        child_comment : comment,
        attached_image : null,
        parent_comment_id : null,
        approval : 0
    };

    console.log("requestData=" + JSON.stringify(requestData));
    $.ajax({
        type:"post",                // method = "POST"
        url:"localhost:8080/api/spajam/if20180003",        // POST送信先のURL
        data:JSON.stringify(requestData),  // JSONデータ本体
        contentType: 'application/json', // リクエストの Content-Type
        dataType: "json",           // レスポンスをJSONとしてパースする
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
            ('0' + today.getDate()).slice(-2) + "/ " +
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