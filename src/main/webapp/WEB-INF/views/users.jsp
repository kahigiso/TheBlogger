<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<ul class="breadcrumb"><li>Manage</li><li>Articles</li></ul>
<c:if test="${SUCCESS_MESSAGE != null}">
  <div class="alert alert-success" role="alert"><c:out value="${SUCCESS_MESSAGE}"/></div>
</c:if> 
<c:if test="${FAILED_MESSAGE != null}">
  <div class="alert alert-danger" role="alert"><c:out value="${FAILED_MESSAGE}"/></div>
</c:if> 
<!-- Button trigger modal -->
<a class="btn btn-primary btn-sm" href="/administrate/users/add.html">
  New User
</a>
 <table class="table table-hover table-striped table-condensed">
	 <thead>
		  <tr>
		    <th>First Name</th>
		    <th>Last Name</th>
		    <th>Email</th>
		    <th>Roles</th>
		    <th colspan="2"></th>
		  </tr>
	  </thead>
  <tbody>
	  <c:forEach items="${users}" var="user">
		  <tr>
		     <td><a href='<spring:url value="/users/details/${user.id}.html"/>'><c:out value="${user.firstName}"/></a></td>
		     <td><a href='<spring:url value="/users/details/${user.id}.html"/>'><c:out value="${user.lastName}"/></a></td>
		     <td><c:out value="${user.email}"/></td>
		     <td><a href='<spring:url value="/administrate/users/edit/${user.id}.html"/>'><button class="btn btn-xs btn-default"><span class="glyphicon glyphicon-edit"></span></button></a></td>
		     <td>
				<button type="submit" class="btn btn-cicle btn-xs btn-danger triggerRemove" href="/administrate/users/delete/${user.id}.html">x</button>
		     </td>
		  </tr>
	   </c:forEach>
  </tbody>
</table>
