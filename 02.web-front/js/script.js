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

    displayAchievementStatus();
    displayAchievementList();
});

function windowLoad() {
    console.log("load");
}

function displayAchievementStatus() {

    var achievementStatus;
    if (isMock) {
        achievementStatus = mockJson.achievementStatus;
    } else {

    }

    $("#achievementStatus").html(achievementStatus);
}

function displayAchievementList() {

    var achivementList;
    if (isMock) {
        achivementList = mockJson.achivementList;
    } else {

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