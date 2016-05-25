<%@ page import="hsenid.Mapping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>

<html lang="en">
<fmt:setLocale value="en"/>
<fmt:bundle basename="Language">
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
        </form>

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
                        <c:set var="s2" value='${requestScope["fromText"]}'/>
                        <c:if test="${not empty s2}">
                            <c:out value="${s2}"></c:out>
                        </c:if>
					</textarea>

                <select name="from">
                    <%
                        Mapping objMap = new Mapping();
                        String[] values = objMap.sendValues();
                        request.setAttribute("values", values);
                    %>
                        <%--
                    here We set a dynamic select list.
                    I used "selected" attributes to store the selected values when page refreshes.
                    --%>

                    <c:set var="frm" value='${requestScope["from"]}' />
                    <c:forEach var="vals" items="${values}">
                        <%--<option>${vals}</option>--%>
                        <c:choose>
                            <c:when test="${vals eq frm}">
                                <option selected>${vals}</option>
                            </c:when>
                            <c:otherwise>
                                <option>${vals}</option>
                            </c:otherwise>
                        </c:choose>
                        <%--<c:out value="${vals} />--%>
                    </c:forEach>

                </select>
            </div>


        </div>


        <div class="col-md-5">
            <div class="col-md-2">
                <div class="chgclr"><fmt:message key="translate.To"/> <fmt:message key="translate.Text"/></div>

            </div>


            <div class="col-md-10">
					<textarea cols="50" rows="13" name="toText">
                        <c:set var="s1" value='${requestScope["toText"]}'/>

                        <c:if test="${not empty s1}">
                            <c:out value="${s1}"></c:out>
                        </c:if>

					</textarea>

                <select name="to">
                    <c:set var="tot" value='${requestScope["to"]}' />
                    <c:forEach var="valsto" items="${values}">
                        <c:choose>
                            <c:when test="${valsto eq tot}">
                                <option selected>${valsto}</option>
                            </c:when>
                            <c:otherwise>
                                <option>${valsto}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                </select>
            </div>

        </div>

        <div id="tbtn">
            <input type="submit" style="width: 30%" class="btn btn-success btn-lg btn-block"
                   value=<fmt:message key="translate.Translate"/>>
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