<%@ page import="java.util.HashMap, hsenid.Mapping"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html lang="en">

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Menuka's Translate Windows</title>
<style type="text/css">
.test {
	margin-bottom: 10%;
	margin-top: 20%;
	margin-left: 30%;
}

#logout {
	margin-left: 92%;
}

body {
	background: url(images/background.png) no-repeat center;
	background-size: cover;
	width: 100%;
	height: 100%;
}

.chgclr {
	color: white;
}
</style>
</head>

<body>
	<% String name = (String)session.getAttribute("username");%>
	<%="Hello! " + name %>


	<div id="logout">
		<form action="LogOut">
			<input type="submit" class="btn btn-danger" value="Log Out">
		</form>
	</div>

	<div align="center">

		<form class="form" action="GetTranslate">

			<div class="col-md-6 ">

				<div class="col-md-2">
					<div class="chgclr">From Text</div>


				</div>
				<div class="col-md-10">


					<textarea cols="60" rows="13" name="fromText">
						<%
                            String s2 = (String) request.getAttribute("fromText");
                            if (s2 != null) {
                                out.println(s2);
                            }
                        %>
					</textarea>

					<select name="from">
						<%
                    Mapping objMap = new Mapping();
                    String[] values = objMap.sendValues();
                    %>
						<%--
                    here We set a dynamic select list.
                    I used "selected" attributes to store the selected values when page refreshes.
                    --%>
						<%


                    for (int i = 0; i < values.length; i++) {
                    if (values[i].equals(request.getAttribute("from"))) {
                    out.println("<option selected>" + values[i] + "</option>");
                    } else {
                    out.println("<option>" + values[i] + "</option>");
                    }
                    }
                    %>

					</select>
				</div>


			</div>


			<div class="col-md-6">
				<div class="col-md-2">
					<div class="chgclr">To Text</div>

				</div>


				<div class="col-md-10">
					<textarea cols="60" rows="13" name="toText">

					<%
                        String s1 = (String) request.getAttribute("toText");
                        if (s1 != null) {
                            out.println(s1);
                        }
                    %>
					</textarea>

					<select name="to">
						<%


                    for (int i = 0; i < values.length; i++) {
                    if (values[i].equals(request.getAttribute("to"))) {
                    out.println("<option selected>" + values[i] + "</option>");
                    } else {
                    out.println("<option>" + values[i] + "</option>");
                    }
                    }
                    %>
					</select>
				</div>

			</div>

			<div>
				<input type="submit" class="btn btn-success btn-lg btn-block"
					value="Translate" style="width: 50%">
			</div>


		</form>

	</div>

	<div class="test">

		<%--
    Here the credit is given as the yandex is instructed.
    --%>

		<a href="Translate http://translate.yandex.com/translate.jsp" style="color:#FFFFFF">
			<div><h3>Powered by Yandex.Translate</h3></div>
		</a>
	</div>


</body>
</html>