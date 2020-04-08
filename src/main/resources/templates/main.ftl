<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Main">
<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>
<div>Main! Hello, ${username}!</div>
<div>
	To see countries click <a href="/countries">here</a>
</div>
</@c.page>