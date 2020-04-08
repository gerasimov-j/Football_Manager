<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Registration">
Add new user
 ${message?ifExists}
<@l.login "/registration" />
</@c.page>