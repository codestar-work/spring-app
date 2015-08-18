<#include "header.ftl">
<div class="container">
	
</div>

<div class="container">
	<a href="${request.contextPath}/post" class="btn btn-default">New</a>
	<#list model["posts"] as post>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<a href="${request.contextPath}/view/${post.id}">
					${post.topic}
				</a>
			</h3>
		</div>
		<div class="panel-body">
			${post.detail}
		</div>
	</div>
	</#list>
</div>
<#include "footer.ftl">
