<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <style type="text/css"><#include "css/code.css"></style>
</head>
<body>
<div id="code_and_date_container">
    <#list codeDtoList as codeDto>
        <div class="code-and-date">
            <span id="load_date">${codeDto.getDate()}</span>
            <pre id="code_snippet">${codeDto.getCode()}</pre>
        </div>
    </#list>
</div>
</body>
</html>