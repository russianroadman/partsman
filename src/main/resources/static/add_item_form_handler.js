/*
var form = document.getElementById("add");
var option = form.getElementsByClassName("type")[0];
option.addEventListener('change', checkQtty);

function checkQtty(){

    var form = document.getElementById("add");
    var option = form.getElementsByClassName("type")[0].value;
    if (option != "part"){
        document.getElementsByClassName("number")[0].value = "";
        document.getElementsByClassName("number")[0].placeholder = "-";
        document.getElementsByClassName("number")[0].readOnly = true;
    } else {
        document.getElementsByClassName("number")[0].readOnly = false;
    }

}
*/

function addItem(snum, title){
    var form = document.getElementById("add");
    form.getElementsByClassName("title")[0].value = title;
    form.getElementsByClassName("snum")[0].value = snum;
}