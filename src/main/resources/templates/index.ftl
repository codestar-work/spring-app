<#include "header.ftl">

<div class="container">
	<div class="row">
		<#list model["posts"] as post>
		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
			<a href="${request.contextPath}/view/${post.id}">
				<div class="panel panel-info highlight">
					<div class="panel-heading">
						<h3 class="panel-title">
							${post.topic[0..*40]}
						</h3>
					</div>
					<div class="panel-body">
						<#if post.file != "unknown.jpg">
						<img class="highlight" 
							src="${request.contextPath}/upload/${post.file}" 
						/>
						</#if>
						<p>
							${post.detail[0..*200]}
						</p>
					</div>
				</div>
			</a>
		</div>
		</#list>
	</div>
</div>
<#include "footer.ftl">
