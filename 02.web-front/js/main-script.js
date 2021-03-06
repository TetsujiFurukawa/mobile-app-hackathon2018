﻿var jsonData;
var userId;
var isMock = false;
var currencyList;
var mockJson = {
        workList : [
            {
                work_id : 1,
                pay_date : "2018/4/1",
                user_id : 1,
                work_item_id : 1,
                child_comment : "おとうさんきょうは算数のテストで100点取ったよ分数だったけどむずかしくなかったよ。",
                attached_image : null,
                parent_comment_id : null,
                approval : 0,
                work_item_name : "テストで100てん",
                currency_id : "gold",
                number : 10,
                approval_message : null
            },
            {
                work_id : 2,
                pay_date : "2018/4/1",
                user_id : 1,
                work_item_id : 2,
                child_comment : null,
                attached_image : null,
                parent_comment_id : null,
                approval : 1,
                work_item_name : "まらそん１かい",
                currency_id : "silver",
                number : 1,
                approval_message : null
            },
            {
                work_id : 3,
                pay_date : "2018/3/1",
                user_id : 1,
                work_item_id : 3,
                child_comment : null,
                attached_image : null,
                parent_comment_id : null,
                approval : 1,
                work_item_name : "テストで90てん",
                currency_id : "bronze",
                number : 5,
                approval_message : null
            }
        ],
        currencyList : [
            {
                currency_id : "gold",
                number : 10
            },
            {
                currency_id : "silver",
                number : 1
            },
            {
                currency_id : "bronze",
                number : 5
            }
        ],
        status : "おねだりせいこうまであと　90ごおるど",
        isParent : false
    };

$(function(){
    windowLoad();

    getUserId();
    callAPi();
    saveData();

    displayButton();
    displayStatus();
    displayCurrencyList()
    displayWorkList();
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
        user_id: userId
    };

    $.ajax({
        type:"post",                // method = "POST"
        url:"http://40.74.73.197:8080/api/spajam/if20180002",        // POST送信先のURL
        data:JSON.stringify(requestData),  // JSONデータ本体
        contentType: 'application/json', // リクエストの Content-Type
        dataType: "json",           // レスポンスをJSONとしてパースする
        async:false,
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

function saveData() {
    if (isMock) {
        sessionStorage.setItem("userData",JSON.stringify(mockJson));
    } else {
        sessionStorage.setItem("userData",JSON.stringify(jsonData));
    }
}

function displayButton() {

    var isParent;
    if (isMock) {
        isParent = mockJson.isParent;
    } else {
        isParent = jsonData.isParent;
    }
    if (isParent) {
        $("#todayWork").hide();
        $("#exchange").hide();
        $("#spanyan").hide();
        $("#status").hide();
        $("#currencyTable").hide();
    }
}

function displayStatus() {

    var status;
    if (isMock) {
        status = mockJson.status;
    } else {
        status = jsonData.status;
    }

    $("#status").html(status);
}

function displayWorkList() {

    var workList;
    if (isMock) {
        workList = mockJson.workList;
    } else {
        workList = jsonData.workList;
    }

    for (var i in workList) {
        displayRow(workList[i]);
    }
}

function displayRow(work) {
    
    var tabel = document.getElementById("workList");
    var tr = tabel.insertRow(-1);
    var td1 = tr.insertCell(-1),
        td2 = tr.insertCell(-1),
        td3 = tr.insertCell(-1),
        td4 = tr.insertCell(-1);

    td1.innerHTML = work.pay_date;
    td2.innerHTML = work.work_item_name;
    td3.innerHTML = toNedan(work.currency_id, work.number);
    td4.innerHTML = toSyounin(work.approval);

    tr.onclick = function () {trClick(work.work_id);};
}

function trClick(workId) {
    console.log("click workId=" + workId);
    location.href='regist_money_for_adult.html?workId=' + workId;
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

function toSyounin(approval) {

    var syounin;
    switch (approval) {
        case 1:
            syounin = "おっけー";
            break;
        case 2:
            syounin = "もうすこし";
            break;
        default:
            syounin = "みかくにん";
    }
    return syounin;
}

function scrounge() {
    location.href='regist_compensation.html';
}

function todayWork() {
    location.href='regist_money_for_child.html';
}

function exchange() {
    location.href='money_trade.html';
}

function logout() {
    sessionStorage.clear();
    location.href='index.html';
}

function displayCurrencyList() {
    getCurrencyList();

    var tbody = document.getElementById("currencyList");

    var currencyNames = {gold: 'ごーるど', silver: 'しるばー', bronze: 'ぶろんず' };
    var rows = currencyList.map(item => `<td>${currencyNames[item.currency_id]}</td><td>${item.number}</td>`)
      .map(item => `<tr>${item}</tr>`);
    var tbodyHtml = `${rows.join('')}`;
    tbody.innerHTML = (tbodyHtml);
}

function getCurrencyList() {
    currencyList = jsonData.currencyList;
    console.log(currencyList);
}