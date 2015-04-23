<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>  
<%@ include file="../layouts/taglib.jsp" %>
<form class="form-signin" role="form" action='<spring:url value="/j_spring_security_check"/>' method="POST">
	<h2 class="form-signin-heading">Login</h2>
	<c:if test="${error eq true}">
		<p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
	</c:if>
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" name="username"  placeholder="Username" value="<c:if test="${not empty param.loing_error}">${SPRING_SECURITY_LAST_USERNAME}</c:if>" required autofocus />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Password">
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit" class="btn btn-lg btn-primary btn-block">Sign in</button>
</form>
