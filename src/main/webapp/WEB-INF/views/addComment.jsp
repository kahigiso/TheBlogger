<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<div class ="panel panel-default">
	<div class="panel-heading"><h3 class="panel-title">Add Category</h3></div>
	  <div class="panel-body">
	<form:form commandName="comment" cssClass="form">
		<form:hidden path="article"/>
		<form:hidden path="parent"/>
	  	<div class="form-group">
		  	<div class="col-sm-8">
			    <label for="name" class="col-sm-4 control-label">Name:</label>
			    <form:input path="name" cssClass="form-control input-sm"/>
			     <form:errors path="name"  cssClass="has-error"/>
		    </div>
	  	</div>
	  	<div class="form-group">
		  	<div class="col-sm-8">
			    <label for="email" class="col-sm-4 control-label">Email:</label>
			    <form:input path="email" cssClass="form-control input-sm"/>
			     <form:errors path="email"  cssClass="has-error"/>
		    </div>
	  	</div>
	  	<div class="form-group">
		  	<div class="col-sm-8">
			    <label for="message" class="col-sm-4 control-label">Your Message:</label>
			    <form:textarea path="message" cssClass="form-control textarea-sm"/>
			     <form:errors path="message"  cssClass="has-error"/>
		    </div>
	  	</div>
	    <div class="form-group">
		  	<div class="col-sm-8">
		  		<input type="submit" value="${comment.id!=null? 'Update':'Sent'}" class="btn btn-lg btn-primary" />
		  	</div>
	  	</div>
	</form:form>
	</div>
</div>
