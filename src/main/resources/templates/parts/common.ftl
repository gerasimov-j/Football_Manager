<#macro page title>
<#import "login.ftl" as l>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FM | ${title}</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<div>
    <span><a href="/">Greeting</a></span>
    <span><a href="/main">Main</a></span>
    <span><a href="/countries">Countries</a></span>
    <span><a href="/user">User list</a></span>
    <span><a href="/registration">Registration</a></span>
    <@l.logout />
</div>
<#nested>
</body>
</html>
</#macro>