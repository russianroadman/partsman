function deletePost(value){
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/brands/delete", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        id: value
    }));
}

function updatePost(value){
    document.getElementsByClassName("update-id")[0].value = value;
}