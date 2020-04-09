<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Registration">
  <h5 class="mb-1">Add new user</h5>
  <div class=" mb-2 text-danger">${message?ifExists}</div>
  <@l.login "/registration" "Sign Up" true/>
</@c.page>