<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*,entity.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Web</title>
	<link href="/css/bootstrap.css" rel="stylesheet" />
	<link href="/css/main.css" rel="stylesheet" />
</head>
<body>

<div class="container">
	<ul>
<%
	List<Post> posts = (List<Post>)request.getAttribute("posts");
	for (int i = 0; i < posts.size(); i++) {
		Post p = posts.get(i);
%>
	<li>
		<a href="/view/<%= p.getId() %>">
			<%= p.getTopic() %>
		</a>
	</li>
<%
	}
%>
	</ul>
</div>

<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
