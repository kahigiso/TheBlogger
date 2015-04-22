<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<form:form commandName="role" cssClass="form">
  <div class="form-group">
  	<div class="col-sm-8">
	    <label for="name" class="col-sm-4 control-label">Role</label>
	    <form:input path="name" cssClass="form-control input-sm"/>
    </div>
  </div>
  <div class="form-group">
  	<div class="col-sm-8">
  		<input type="submit" value="Add" class="btn btn-lg btn-primary" />
  	</div>
  </div>
</form:form>

 <table class="table table-hover table-bordered table-striped">
	 <thead>
		  <tr>
		    <th>Name</th>
		    <th colspan="2">Action</th>
		  </tr>
	  </thead>
  <tbody>
	  <c:forEach items="${roles}" var="role">
		  <tr>
		    <td><c:out value="${role.name}"/></td>
		     <td>Delete</td>
		     <td>Activate</td>
		  </tr>
	   </c:forEach>
  </tbody>
</table>