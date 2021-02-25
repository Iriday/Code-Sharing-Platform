<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <style type="text/css"><#include "css/input_code.css"></style>
</head>
<body>
<div id="form_container">
    <form>
        <label><textarea id="code_snippet"></textarea></label>
        <br>
        <label>Time restriction: <input id="time_restriction" type="number"></label>
        <label>Views restriction: <input id="views_restriction" type="number"></label>
        <br>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </form>
</div>

<script>
    function send() {
        let xhr = new XMLHttpRequest()
        xhr.open("POST", "/api/code/new", false)
        xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8")
        xhr.send(JSON.stringify({
            "code": document.getElementById("code_snippet").value,
            "time": document.getElementById("time_restriction").value,
            "views": document.getElementById("views_restriction").value
        }))
        if (xhr.status === 200) alert("Success!")
    }
</script>
</body>
</html>