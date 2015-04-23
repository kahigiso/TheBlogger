<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<div class ="panel  panel-default">
	<div class="panel-heading"><h3 class="panel-title">Add Category</h3></div>
	  <div class="panel-body">
		<form:form commandName="category" cssClass="form" action="addo">
		  	<div class="form-group">
			  	<div class="col-sm-8">
				    <label for="name" class="col-sm-4 control-label">Name</label>
				    <form:input path="name" cssClass="form-control input-sm"/>
				    <form:errors path="name"  cssClass="has-error"/>
			    </div>
		  	</div>
		  	<div class="form-group">
			  	<div class="col-sm-8">
				    <label for="description" class="col-sm-4 control-label">Description</label>
				    <form:textarea path="description" cssClass="form-control textarea-sm"/>
				     <form:errors path="description"  cssClass="has-error"/>
			    </div>
		  	</div>
		    <div class="form-group">
			  	<div class="col-sm-8">
			  		<input type="submit" value="${category.id!=null?'Update':'Save'}" class="btn btn-lg btn-primary" />
			  	</div>
		  	</div>
		</form:form>
	</div>
</div>