<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <style type="text/css"><#include "css/input_code.css"></style>
</head>
<body>
<form>
    <label><textarea id="code_snippet"></textarea></label>
    <br>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
<script>
    function send() {
        let xhr = new XMLHttpRequest()
        xhr.open("POST", "/api/code/new", false)
        xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8")
        xhr.send(JSON.stringify({"code": document.getElementById("code_snippet").value}))

        if (xhr.status === 200) alert("Success!")
    }
</script>
</body>
</html>