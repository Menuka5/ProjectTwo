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
                    <li class="active"><a href="translate.jsp"><fmt:message key="index.translator"/> <span class="sr-only">(current)</span></a>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><fmt:message key="top.User"/> <fmt:message key="top.Management"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="registration.jsp"><fmt:message key="top.Add"/> <fmt:message key="top.User"/></a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li><a href="LoadSearch.jsp"><fmt:message key="top.Search"/> <fmt:message key="top.User"/></a></li>

                        </ul>
                    </li>
                </ul>


            </div>
        </div>
    </nav>
</div>

<script type='text/javascript'>
    function callMe() {
        $.ajax({url: "CountryInformation"});
    }
</script>
