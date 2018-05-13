$(function(){
    windowLoad();
});

function windowLoad() {
    console.log("load");
}

function login() {
    sessionStorage.userId = $("#userId").val();
    location.href='main.html';
}