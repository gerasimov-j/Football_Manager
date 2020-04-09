<#import "parts/common.ftl" as c>

<@c.page "Countries">
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/countries" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Filter by name">
            <button type="submit" class="btn btn-primary ml-2">Filter</button>
        </form>
    </div>
</div>
<a class="btn btn-primary" data-toggle="collapse" href="#addCountry" role="button" aria-expanded="false" aria-controls="addCountry">
    Add new country
</a>
<div class="collapse" id="addCountry">
    <div class="form-group mt-3">
	    <form method="post" enctype="multipart/form-data">
	        <div class="form-group">
	            <input type="text" class="form-control" name="name" placeholder="Enter name" />
	        </div>
	        <div class="form-group">
	            <input type="text" class="form-control" name="tag" placeholder="And tag">
	        </div>
	        <div class="form-group">
	            <div class="custom-file">
	                <input type="file" name="file" id="customFile">
	                <label class="custom-file-label" for="customFile">Choose file</label>
	            </div>
            </div>
	        <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
	            <button type="submit" class="btn btn-primary">Add</button>
            </div>
	    </form>
    </div>
</div>

<div class="card-columns">
<#list countries as country>
    <div class="card m-2 h-100">
	    <#if country.flagFileName??>
	        <img src="/countryFlags/${country.flagFileName}" height="10" width="15" class=".img-thumbnail">
	    </#if>
	    <span>${country.name} (<i>${country.tagName}</i>)</span>
	    <i></i>
    </div>
	<#else>
	No countries
	</#list>
</div>
</@c.page>