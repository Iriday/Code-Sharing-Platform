<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <style type="text/css"><#include "css/code.css"></style>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<div id="code_and_date_container">
    <div class="code-and-date">
        <span id="load_date">${codeDto.getDate()}</span>
        <#if codeDto.timeLimit>
            <br><span id="time_restriction">The code will be available for ${codeDto.time} seconds</span>
        </#if>
        <#if codeDto.viewsLimit>
            <br><span id="views_restriction">${codeDto.views} more views available</span>
        </#if>
        <pre id="code_snippet"><code>${codeDto.getCode()}</code></pre>
    </div>
</div>
</body>
</html>