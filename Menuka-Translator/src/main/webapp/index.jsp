<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<title>Menuka's Login Page</title>

<style type="text/css">
.container {
	width: 500px;
	clear: both;
	margin-top: 20%;
	margin-left: 30%;
}

.container input {
	width: 80%;
	clear: both;
}

.container table {
	border-spacing: 5em;
}
</style>
</head>
<body>


	<div class="container">
		<%
							String s2 = (String) request.getAttribute("Error");
							if (s2 != null) {
								out.println(s2);
							}
						%>

		<form action="MyServlet">
			Username : <input type="text" name="username"> <br /> <br>
			password : &nbsp;<input type="password" name="password"> <br />
			<br> <input type="submit" value="Submit" style="width: 100%">

		</form>


	</div>

</body>
</html>