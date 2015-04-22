<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
 <table class="table table-hover table-bordered table-striped">
	 <thead>
		  <tr>
		    <th>First Name</th>
		    <th>Last Name</th>
		    <th>Email</th>
		    <th>Roles</th>
		    <th colspan="3">Action</th>
		  </tr>
	  </thead>
  <tbody>
	  <c:forEach items="${users}" var="user">
		  <tr>
		    <td colspan="2"><a href='<spring:url value="/user-details/${user.id}.html"/>'>${user.getFullName()}</a></td>
		     <td><c:out value="${user.email}"/></td>
		     <td>Delete</td>
		     <td>Activate</td>
		  </tr>
	   </c:forEach>
  </tbody>
</table>
