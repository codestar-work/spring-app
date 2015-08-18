<#include "header.ftl">
<div class="container">
	<h1>Post</h1>
	<form method="post">
		<input name="topic"
			class="form-control"
			type="text"
			placeholder="Topic"
		/>
		<textarea name="detail"
			class="form-control"
			placeholder="Detail"
		></textarea>
		<input type="submit" class="btn btn-primary" value="Post" />
	</form>
</div>
<#include "footer.ftl">
