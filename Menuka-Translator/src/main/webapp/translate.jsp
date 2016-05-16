<%@ page import="hsenid.Mapping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>

<html lang="en">
<fmt:setLocale value="en"/>
<fmt:bundle basename="languageFiles.Language">
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/translate.css">
    <link rel="stylesheet" href="background.css">

    <meta charset="UTF-8">
    <title><fmt:message key="translate.Translate"/> <fmt:message key="translate.Window"/></title>

    <SCRIPT type="text/javascript">
        function MoveBoxContent(fieldA, fieldB, fieldC, fieldD) {
            var temp = fieldA.value;
            var temp2 = fieldC.value;
            fieldC.value = fieldD.value;
            fieldD.value = temp2;
            fieldA.value = fieldB.value;
            fieldB.value = temp;
        }
    </script>

    <style type="text/css">

    </style>

</head>

<body>
<%@include file="top.jsp" %>
<div>

    <div id="logout">
        <form action="LogOut">
            <input type="submit" class="btn btn-danger" value=<fmt:message key="translate.Logout"/>>
        </form>6
    </div>


</div>

<div>

    <form class="form" action="GetTranslate" name="form1">

        <div class="col-md-6">

            <div class="col-md-2">
                <div class="chgclr"><fmt:message key="translate.From"/> <fmt:message key="translate.Text"/></div>


            </div>
            <div class="col-md-10">


					<textarea cols="50" rows="13" name="fromText">
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


        <div class="col-md-5">
            <div class="col-md-2">
                <div class="chgclr"><fmt:message key="translate.To"/> <fmt:message key="translate.Text"/></div>

            </div>


            <div class="col-md-10">
					<textarea cols="50" rows="13" name="toText">

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

        <div id="tbtn">
            <input type="submit" class="btn btn-success btn-lg btn-block"
                   value=<fmt:message key="translate.Translate"/> style="width: 30%">
        </div>


    </form>

</div>


<div id="swap">
    <a href="#" class="btn btn-primary btn-warning"
       onClick="MoveBoxContent(document.form1.fromText, document.form1.toText, document.form1.from, document.form1.to);"><span
            class="glyphicon glyphicon-resize-horizontal"><fmt:message key="translate.Swap"/></span> </a>
</div>


<div class="test">

    <%--
Here the credit is given as the yandex is instructed.
--%>

    <a href="Translate http://translate.yandex.com/translate.jsp"
       style="color: #FFFFFF">
        <div>
            <h3>Powered by Yandex.Translate</h3>
        </div>
    </a>
</div>

</fmt:bundle>
</body>
</html>