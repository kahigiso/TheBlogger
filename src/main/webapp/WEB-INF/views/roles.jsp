<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
 <table class="table table-hover table-striped">
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