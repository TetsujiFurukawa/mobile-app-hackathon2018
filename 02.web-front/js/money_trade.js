var lat;
var lng;
var isMock = true;
var jsonData;
var currencyList;
var mockJson = {
    userList : [
        {
            user_id : 2,
            user_namre : "けんちゃん"
        },
        {
            user_id : 3,
            user_namre : "かとちゃん"
        },
        {
            user_id : 4,
            user_namre : "よしこちゃん"
        }
    ]
};

$(function(){
    windowLoad();
    $("#exchange").prop("disabled", true);
    getLocation();
    displayCurrencyList();
});

function windowLoad() {
    console.log("load");
}

function getLocation() {
    navigator.geolocation.getCurrentPosition(
        successCallback, errorCallback);
}

function successCallback (pos) {
    lat = pos.coords.latitude;
    lng = pos.coords.longitude;

    console.log(lat, lng);

    callPostLocation();
  }

function errorCallback(error) {
    console.log("error:" + error.message);
    $("#errorMsg").show();
}

function callPostLocation() {

    var userId = getUserId();
    var time = getTime();
    var requestData = {
        user_id : userId,
        search_datetime : time,
        latitude :lat,
        longitude : lng
    };

    console.log("requestData=" + JSON.stringify(requestData));

    if (isMock) {
        return;
    }

    $.ajax({
        type:"post",                // method = "POST"
        url:"localhost:8080/api/spajam/if20180005",        // POST送信先のURL
        data:JSON.stringify(requestData),
        contentType: 'application/json', // リクエストの Content-Type
        dataType: "json",           // レスポンスをJSONとしてパースする
        success: function(responseData) {   // 200 OK時
            console.log("callAPi success");
        },
        error: function() {         // HTTPエラー時
            $("#errorMsg").show();
        },
        complete: function() {      // 成功・失敗に関わらず通信が終了した際の処理
            console.log("callAPi end");
        }
    });
}

function displayCurrencyList() {
    getCurrencyList();

    var tbody = document.getElementById("currencyList");

    var currencyNames = {gold: 'ごーるど', silver: 'しるばー', bronze: 'ぶろんず' };
    var rows = currencyList.map(item => `<td><input type="radio" id="${item.currency_id}" name="currency_id" value="${item.currency_id}" data-item="${encodeURIComponent(JSON.stringify(item))}" onchange="curChanged(this);" /><label for="${item.currency_id}"></label></td><td>${currencyNames[item.currency_id]}</td><td>${item.number}</td>`)
      .map(item => `<tr>${item}</tr>`);
    var tbodyHtml = `${rows.join('')}`;
    tbody.innerHTML = (tbodyHtml);
}

function curChanged(el)  {
    var obj = JSON.parse(decodeURIComponent(el.dataset.item));
    var currncy_id = el.value;
    console.log('obj:', obj, 'currncy_id:', currncy_id);
}

function getCurrencyList() {
    currencyList = JSON.parse(sessionStorage.getItem("userData")).currencyList;
    console.log(currencyList);
}

function serchFriend() {
    getUserList();
    displayFriend();
    $("#exchange").prop("disabled", false);
}

function getUserList() {

    var userId = getUserId();
    var requestData = {
        user_id : userId,
    };

    console.log("requestData=" + JSON.stringify(requestData));

    if (isMock) {
        return;
    }

    $.ajax({
        type:"post",                // method = "POST"
        url:"localhost:8080/api/spajam/if20180006",        // POST送信先のURL
        data:JSON.stringify(requestData),
        contentType: 'application/json', // リクエストの Content-Type
        dataType: "json",           // レスポンスをJSONとしてパースする
        success: function(responseData) {   // 200 OK時
            jsonData = responseData;
        },
        error: function() {         // HTTPエラー時
            $("#errorMsg").show();
        },
        complete: function() {      // 成功・失敗に関わらず通信が終了した際の処理
            console.log("callAPi end");
        }
    });
}

function getUserId() {
    var userId = sessionStorage.userId;
    console.log(userId);
    return  userId;
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

function displayFriend() {
    var userList;
    if (isMock) {
        userList = mockJson.userList;
    } else {
        userList = jsonData.userList;
    }

    var tbody = document.getElementById("friendList");

    var rows = userList.map(item => `<td><input type="radio" id="${item.user_id}" name="user_id" value="${item.user_id}" data-item="${encodeURIComponent(JSON.stringify(item))}" onchange="curChanged(this);" /><label for="${item.user_id}"></label></td><td>${item.user_namre}</td>`)
      .map(item => `<tr>${item}</tr>`);
    var tbodyHtml = `${rows.join('')}`;
    tbody.innerHTML = (tbodyHtml);
}

function userChanged(el)  {
    var obj = JSON.parse(decodeURIComponent(el.dataset.item));
    var user_id = el.value;
    console.log('obj:', obj, 'user_id:', user_id);
}

function exchange() {

    var time = getTime();
    var userId = getUserId();
    var selectFriend = document.getElementById("selectFriend");
    var targetUserId = selectFriend.user_id.value;
    var selectCurrency = document.getElementById("selectCurrency");
    var currencyId = selectCurrency.currency_id.value;
    var number = document.getElementById("amount").value;
    var requestData = {
        pay_date : time,
        src_user_id : userId,
        target_user_id : targetUserId,
        currency_id : currencyId,
        number : number
    };

    console.log("requestData=" + JSON.stringify(requestData));

    if(isMock) {
        location.href='main.html';
    }

    $.ajax({
        type:"post",                // method = "POST"
        url:"localhost:8080/api/spajam/if20180004",        // POST送信先のURL
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

function back() {
    location.href='main.html';
}