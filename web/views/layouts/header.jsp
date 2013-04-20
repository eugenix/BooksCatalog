<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books app</title>
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
            <s:a action="search" cssClass="brand">BooksCatalog</s:a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="divider-vertical"></li>
                    <li id="search"><a href="<s:url action='search'/>"><i class="icon-home icon-white"></i> Home</a></li>
                    <li id="add-book"><a href="<s:url action='add-book'/>"><i class="icon-plus-sign icon-white"></i> Add</a></li>
                </ul>
                <div class="pull-right">
                    <ul class="nav pull-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Welcome, <i class="icon-user icon-white"></i> <s:property value="#session.user.login"/> <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action='settings'/>"><i class="icon-cog"></i> Preferences</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action='logout'/>"><i class="icon-off"></i> Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("#<s:property value="actionName" />").addClass("active");
    })
</script>