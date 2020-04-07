<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Countries">
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Введите страну" />
        <input type="text" name="tag" placeholder="И тег">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список стран</div>
<form method="get" action="/countries">
    <input type="text" name="filter" value="${filter!}">
    <button type="submit">Найти</button>
</form>
<#list countries as country>
<div>
    <b>${country.id}</b>
    <span>${country.name}</span>
    <i>${country.tagName}</i>
    <strong>${country.authorName}</strong>
</div>
<#else>
No countries
</#list>
</@c.page>