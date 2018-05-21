$(function(){
    windowLoad();
    displayButton();
});

function windowLoad() {
    console.log("load");
}

function displayButton() {
    var userData = JSON.parse(sessionStorage.getItem("userData"));
    console.log(userData);
    if (userData.isParent) {
        $("#scrounge").hide();
    } else {
        $("#bought").hide();
    }
}