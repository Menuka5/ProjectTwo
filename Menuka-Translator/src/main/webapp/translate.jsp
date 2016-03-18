
<%@ page import="java.util.HashMap, hsenid.Mapping"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>



<html lang="en">
<head>
<meta charset="UTF-8">
<title>Menuka's Translate Windows</title>
<style type="text/css">
.test {
	margin-bottom: 10%;
	margin-top: 20%;
        margin-left: 30%;
}
</style>
</head>
<body>

	<div align="center">
		<form action="GetTranslate">
			<table>
				<tr>
					<td>From Text &nbsp&nbsp&nbsp&nbsp</td>

					<td><textarea cols="60" rows="13" name="fromText">
						<%
							String s2 = (String) request.getAttribute("fromText");
							if (s2 != null) {
								out.println(s2);
							}
						%>
					</textarea></td>

					<td>&nbsp&nbsp&nbsp&nbsp</td>

					<td>To Text &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>

					<td><textarea cols="60" rows="13" name="toText">
					
					<%
											String s1 = (String) request.getAttribute("toText");
											if (s1 != null) {
												out.println(s1);
											}
										%>
					
				
					</textarea></td>
				</tr>

				<tr>
					<td></td>
					<td><select name="from">
							<%
								Mapping objMap = new Mapping();
								String[] keys = objMap.sendKeys();
								String[] values = objMap.sendValues();
							%>

							<%
								for (int i = 1; i < keys.length; i++) {
							%>
							<option value="<%=keys[i]%>"><%=values[i]%></option>
							<%
								}
							%>

					</select></td>
					<td></td>
					<td><select name="to">
							<%
								for (int i = 1; i < keys.length; i++) {
							%>
							<option value="<%=keys[i]%>"><%=values[i]%></option>
							<%
								}
							%>
					</select></td>
				</tr>


			</table>
			<input type="submit" value="Translate" style="width: 50%">
		</form>
		<%
			
		%>
	</div>

	<div class="test">
		<a href="Translate http://translate.yandex.com/">Powered by
			Yandex.Translate</a>
	</div>


</body>
</html>