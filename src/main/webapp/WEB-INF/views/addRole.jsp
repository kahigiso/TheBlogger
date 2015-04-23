<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<form:form commandName="role" cssClass="form">
  	<div class="form-group">
	  	<div class="col-sm-8">
		    <label for="name" class="col-sm-4 control-label">Name:</label>
		    <form:input path="title" cssClass="form-control input-sm"/>
	    </div>
  	</div>
    <div class="form-group">
	  	<div class="col-sm-8">
	  		<input type="submit" value="${role.id!=null? 'Update':'Save'}" class="btn btn-lg btn-primary" />
	  	</div>
  	</div>
</form:form>

