<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Login">
  <h5 class="mb-1">Login</h5>
  <div class=" mb-2 text-danger">${message?ifExists}</div>
<@l.login "/login" "Sign in" false/>
</@c.page>