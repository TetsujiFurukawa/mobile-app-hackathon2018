var jsonData;
var userId;
var isMock = true;
var mockJson = {
        achievementStatus: "おねだりせいこうまであと　90ごおるど",
        achivementList : [
            {
                date : "2018/4/1",
                name : "テストで100てん",
                amount : "10ごおるど",
                approval : "おっけー"
            },
            {
                date : "2018/4/1",
                name : "まらそん１かい",
                amount : "1しるばあ",
                approval : "おっけー"
            },
            {
                date : "2018/3/1",
                name : "テストで90てん",
                amount : "5ごおるど",
                approval : "おっけー"
            }
        ]
    };

$(function(){
    windowLoad();

    getUserId();
    callAPi();

    displayAchievementStatus();
    displayAchievementList();
});

function windowLoad() {
    console.log("load");
}

function getUserId() {
    userId = sessionStorage.userId;
    console.log(userId);
}

function callAPi() {

    if (isMock) {
        return;
    }

    var requestData = {
        userId: userId
    };

    $.ajax({
        type:"post",                // method = "POST"
        url:"localhost:8080",        // POST送信先のURL
        data:JSON.stringify(requestData),  // JSONデータ本体
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

function displayAchievementStatus() {

    var achievementStatus;
    if (isMock) {
        achievementStatus = mockJson.achievementStatus;
    } else {
        achievementStatus = jsonData.achievementStatus;
    }

    $("#achievementStatus").html(achievementStatus);
}

function displayAchievementList() {

    var achivementList;
    if (isMock) {
        achivementList = mockJson.achivementList;
    } else {
        achivementList = jsonData.achivementList;
    }

    for (var i in achivementList) {
        displayRow(achivementList[i]);
    }
}

function displayRow(achivement) {
    
    var tabel = document.getElementById("achivementList");
    var tr = tabel.insertRow(-1);
    var td1 = tr.insertCell(-1),
        td2 = tr.insertCell(-1),
        td3 = tr.insertCell(-1),
        td4 = tr.insertCell(-1);

    td1.innerHTML = achivement.date;
    td2.innerHTML = achivement.name;
    td3.innerHTML = achivement.amount;
    td4.innerHTML = achivement.approval;
}