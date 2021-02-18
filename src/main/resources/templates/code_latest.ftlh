<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codeDtoList as codeDto>
    <div>
        <span id="load_date">${codeDto.getDate()}</span>
        <pre id="code_snippet">${codeDto.getCode()}</pre>
    </div>
</#list>
</body>
</html>