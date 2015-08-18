<#include "header.ftl">
<div class="container">
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
</div>
<#include "footer.ftl">
