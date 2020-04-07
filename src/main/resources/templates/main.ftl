<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Main">
<div>
    <@l.logout />
</div>
<div>Main! Hello, ${username}!</div>
<div>
	To see countries click <a href="/countries">here</a>
</div>
</@c.page>