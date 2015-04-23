<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<div class ="panel  panel-default">
	<div class="panel-heading"><h3 class="panel-title" >Add Article</h3></div>
	  <div class="panel-body">
		<form:form commandName="article" cssClass="form" method="POST" action="/manage/articles/addArticle">
		  	<div class="form-group">
			  	<div class="col-sm-8">
				    <label for="title" class="col-sm-4 control-label">Title:</label>
				    <form:input path="title" cssClass="form-control input-sm"/>
				    <form:errors path="title"  cssClass="has-error"/>
			    </div>
		  	</div>
		  	<div class="form-group">
			  	<div class="col-sm-8">
				    <label for="category" class="col-sm-4 control-label">Category:</label>
				   <form:select path="category" cssClass="form-control input-sm">  
						  <form:option value="-" label="--Please Select --"/>
						  <form:options items="${categories}" itemValue="id" itemLabel="name"/>
					</form:select>
					 <form:errors path="category"  cssClass="has-error"/>
			    </div>
		  	</div>
			<div class="form-group">
			  	<div class="col-sm-8">
				    <label for="draft" class="col-sm-4 control-label">Draft:</label>
				   <form:checkbox path="draft" cssClass="form-control input-sm"/>
				    <form:errors path="draft"  cssClass="has-error"/>
			    </div>
		  	</div>
		  	<div class="form-group">
			  	<div class="col-sm-8">
				    <label for="content" class="col-sm-4 control-label">Content:</label>
				    <form:textarea path="content" cssClass="form-control textarea-sm" rows="8" cols="60"/>
				     <form:errors path="content"  cssClass="has-error"/>
			    </div>
		  	</div>
		  	<div class="clearfix"></div>
		    <div class="form-group ">
			  	<div class="col-sm-8">
			  		<input type="submit" value="${article.id!=null? 'Update':'Save'}" class="btn btn-lg btn-primary" />
			  	</div>
		  	</div>
		</form:form>
	</div>
</div>