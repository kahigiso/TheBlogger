<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>   
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
<!-- Google cdn jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style>
 .mytable {
 	font-size: 13px;
 }
</style>
<title><tiles:getAsString name="title"/></title>
</head>
 
<body class="mytable"> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<tilesx:useAttribute name="current"/>
<div class="container">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="<spring:url value="/"/>">The Blogger</a>
	    </div>
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	        <li class="${current=='index' ? 'active':''}"><a href='<spring:url value="/"/>'>Home</a></li>
	       <%-- <security:authorize access="isAuthenticated()"> --%>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Manage<span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li class="${current=='articles' ? 'active':''}"><a href='<spring:url value="/manage/articles.html?p=1"/>'>Articles</a></li>
		            <li class="${current=='categories' ? 'active':''}"><a href='<spring:url value="/manage/categories.html"/>'>Categories</a></li>
		            <li class="${current=='comments' ? 'active':''}"><a href='<spring:url value="/manage/comments.html?p=1"/>'>Comments</a></li>
		          <%-- <security:authorize access="hasRole('ROLE_ADMIN')">  --%>
			            <li class="divider"></li>
			            <li class="${current=='users' ? 'active':''}"><a href='<spring:url value="/administrate/users.html"/>'>Users</a></li>
			            <li class="${current=='roles' ? 'active':''}"><a href='<spring:url value="/administrate/roles.html"/>'>Roles</a></li>
		          <%--  </security:authorize> --%>
		          </ul>
	        	</li>
        	<%-- </security:authorize> --%>
        	<security:authorize access="!isAuthenticated()">
	        	<li class="${current=='login' ? 'active':''}"><a href='<spring:url value="/login.html"/>'>Login</a></li>
	        	<li class="${current=='register' ? 'active':''}"><a href='<spring:url value="/register/register.html"/>'>Register</a></li>
        	</security:authorize>     	
        	<security:authorize access="isAuthenticated()">
        		<li><a href="<spring:url value='/logout'/>">Logout</a></li>
        	</security:authorize>
	      </ul>
	    </div><!-- /.navbar-collapse -->

	  </div><!-- /.container-fluid -->
	</nav>
	<div class="col-lg-12 row row-centered">
		<div class="col-xs-12 col-centered">
			<tiles:insertAttribute name="body"/>
		</div>
		<div class="col-xs-12 col-centered">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</div>
</body>
</html>