<%@ page import="hsenid.Mapping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>

<html lang="en">

<head>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/translate.css">
    <link rel="stylesheet" href="background.css">

    <meta charset="UTF-8">
    <title>Menuka's Translate Windows</title>

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
    <div style="color: white;">
        <h3>
            <%
                String name = (String) session.getAttribute("username");
            %>
            <%="Hello! " + name%>

        </h3>
    </div>

    <div id="logout">
        <form action="LogOut">
            <input type="submit" class="btn btn-danger" value="Log Out">
        </form>
    </div>


</div>

<div>

    <form class="form" action="GetTranslate" name="form1">

        <div class="col-md-6">

            <div class="col-md-2">
                <div class="chgclr">From Text</div>


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
                <div class="chgclr">To Text</div>

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
                   value="Translate" style="width: 30%">
        </div>


    </form>

</div>


<div id="swap">
    <a href="#" class="btn btn-primary btn-warning"
       onClick="MoveBoxContent(document.form1.fromText, document.form1.toText, document.form1.from, document.form1.to);"><span
            class="glyphicon glyphicon-resize-horizontal">swap</span> </a>
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


</body>
</html>