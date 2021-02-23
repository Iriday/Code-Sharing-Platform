<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <style type="text/css"><#include "css/code.css"></style>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<div id="code_and_date_container">
    <#list codeDtoList as codeDto>
        <div class="code-and-date">
            <span id="load_date">${codeDto.getDate()}</span>
            <pre id="code_snippet"><code>${codeDto.getCode()}</code></pre>
        </div>
    </#list>
</div>
</body>
</html>