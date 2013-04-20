<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page</title>
    <link href="<s:url value='/assets/bootstrap/css/bootstrap.css'/>" media="all" type="text/css" rel="stylesheet">
    <link href="<s:url value='/assets/css/style.css'/>" media="all" type="text/css" rel="stylesheet">

    <script src="<s:url value='/assets/js/jquery-1.9.1.min.js'/>" type="text/javascript"></script>
    <script src="<s:url value='/assets/bootstrap/js/bootstrap.js'/>" type="text/javascript"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="brand">BooksCatalog</a>
        </div>
    </div>
</div>
<div class="container">
    <div class="row top-buffer">
        <div class="span4 offset4 well">
            <legend>Welcome</legend>
            <s:if test="hasErrors()">
                <div class="alert alert-error">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <s:actionerror />
                    <s:fielderror />
                </div>
            </s:if>
            <s:form method="POST" action="login">
                <%--<s:textfield  name="username" cssClass="span4" id="username"/>--%>
                <input type="text" placeholder="Login" name="username" class="span4" id="username">
                <input type="password" placeholder="Password" name="password" class="span4" id="password">
                <button class="btn btn-info btn-block" type="submit">Sign in</button>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>