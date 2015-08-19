<#include "header.ftl">

<div class="container">
	<div class="row">
		<#list model["posts"] as post>
		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
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
		</#list>
	</div>
</div>
<#include "footer.ftl">
