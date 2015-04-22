<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<form:form commandName="user" cssClass="form">
  <div class="form-group">
  	<div class="col-sm-8">
	    <label for="firstName" class="col-sm-4 control-label">First Name</label>
	    <form:input path="firstName" cssClass="form-control input-sm"/>
    </div>
  </div>
    <div class="form-group">
  	<div class="col-sm-8">
	    <label for="lastName" class="col-sm-4 control-label">Last Name</label>
	    <form:input path="lastName" cssClass="form-control input-sm"/>
    </div>
  </div>
   <div class="form-group">
  	<div class="col-sm-8">
	    <label for="username" class="col-sm-4 control-label">Username</label>
	    <form:input path="username" cssClass="form-control input-sm"/>
    </div>
  </div>
     <div class="form-group">
  	<div class="col-sm-8">
	    <label for="email" class="col-sm-5 control-label">Email address</label>
	    <form:input path="email" cssClass="form-control input-sm"/>
    </div>
  </div>
  <div class="form-group">
  	<div class="col-sm-8">
	    <label for="password" class="col-sm-5 control-label">Password</label>
	    <form:password path="password" cssClass="form-control input-sm"/>
    </div>
  </div>
    <div class="form-group">
  	<div class="col-sm-8">
  		<input type="submit" value="Register" class="btn btn-lg btn-primary" />
  	</div>
  </div>
</form:form>