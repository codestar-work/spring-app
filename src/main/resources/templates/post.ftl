<#include "header.ftl">
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-6">
			<h1>Post</h1>
			<form method="post">
				<input name="topic"
					class="form-control"
					type="text"
					placeholder="Topic"
					autofocus="autofocus"
				/>
				<textarea name="detail"
					class="form-control"
					placeholder="Detail"
				></textarea>
				<input type="submit" class="btn btn-primary" value="Post" />
			</form>
		</div>
	</div>
</div>
<#include "footer.ftl">
