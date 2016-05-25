<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="AddUser" value="Add user"/>
<c:set var="EditUser" value="Edit user"/>
<c:set var="SearchUser" value="Search user"/>
<c:set var="DeleteUser" value="Delete user"/>
<c:set var="Translate" value="Translate"/>


    <c:set var="perms" value='${"permissions"}' />

    <c:set var="checkAddUser" value="${false}"/>
    <c:set var="checkTranslate" value="${false}"/>
    <c:set var="checkSearchUser" value="${false}"/>
    <c:set var="checkDeleteUser" value="${false}"/>
    <c:set var="checkEditUser" value="${false}"/>

    <c:forEach var="vals" items='${permissions}'>
        <c:if test="${vals eq Translate}">
            <c:set var="checkTranslate" value="${true}"/>
        </c:if>
        <c:if test="${vals eq AddUser}">
            <c:set var="checkAddUser" value="${true}"/>
        </c:if>
        <c:if test="${vals eq SearchUser}">
            <c:set var="checkSearchUser" value="${true}"/>
        </c:if>
        <c:if test="${vals eq DeleteUser}">
            <c:set var="checkDeleteUser" value="${true}"/>
        </c:if>
        <c:if test="${vals eq EditUser}">
            <c:set var="checkEditUser" value="${true}"/>
        </c:if>
    </c:forEach>

    <div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <%
                    String name = (String) session.getAttribute("username");
                %>
                <span class="navbar-brand"><fmt:message key="translate.Hello"/> <%= name%>...</span>

            </div>


            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <c:if test="${checkTranslate}">
                        <li class="active"><a href="translate.jsp"><fmt:message key="index.translator"/> <span class="sr-only">(current)</span></a>
                        </li>
                    </c:if>

                    <c:if test="${checkSearchUser}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><fmt:message key="top.User"/> <fmt:message key="top.Management"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <c:if test="${checkAddUser}">
                                <li>
                                    <a href="registration.jsp"><fmt:message key="top.Add"/> <fmt:message key="top.User"/></a>
                                </li>
                            </c:if>
                                <li><a href="LoadSearch.jsp"><fmt:message key="top.Search"/> <fmt:message key="top.User"/></a></li>

                        </ul>
                    </li>
                    </c:if>
                </ul>
        </div>
    </nav>
    <c:set var="perms" value='${requestScope["permissions"]}' />
    <c:forEach var="vals" items="${perms}">
        <c:out value="${vals}"/>
    </c:forEach>
</div>



<script type='text/javascript'>
    function callMe() {
        $.ajax({url: "CountryInformation"});
    }
</script>
