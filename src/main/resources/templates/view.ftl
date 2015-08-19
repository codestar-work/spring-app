<#include "header.ftl">
<style>
	p {
		max-width: 640px;
		padding-top: 10px;
		margin: 0 auto;
	}
</style>

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
			<img class="highlight" 
				src="${request.contextPath}/upload/${post.file}" 
			/>
			<p>
				${post.detail}
			</p>
		</div>
	</div>
</div>
<#include "footer.ftl">
