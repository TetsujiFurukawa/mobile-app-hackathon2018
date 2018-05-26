$(function(){
    windowLoad();
});

function windowLoad() {
    console.log("load");
}

function login() {
    var name = $("#userId").val();
    sessionStorage.userId = adapt(name);
    location.href='main.html';
}

function adapt(name) {

    var userId;
    switch (name) {
        case "れん":
            userId = "1";
            break;
        case "ゆい":
            userId = "2";
            break;
        case "れんパパ":
            userId = "3";
            break;
        default:
            userId = name;
    }
    return userId;
}