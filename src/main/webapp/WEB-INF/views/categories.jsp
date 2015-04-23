<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$('.triggerRemove').click(function(e){
			e.preventDefault();
			$('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
	})
</script>
<ul class="breadcrumb"><li>Manage</li><li>Categories</li></ul>
<c:if test="${SUCCESS_MESSAGE != null}">
  <div class="alert alert-success" role="alert"><c:out value="${SUCCESS_MESSAGE}"/></div>
</c:if> 
<c:if test="${FAILED_MESSAGE != null}">
  <div class="alert alert-danger" role="alert"><c:out value="${FAILED_MESSAGE}"/></div>
</c:if> 
<a class="btn btn-primary btn-sm" data-toggle="modal" href="/manage/categories/add.html">
  New Category
</a>
 <table class="table table-hover table-striped table-condensed">
	 <thead>
		  <tr>
		    <th class="col-sm-3">Name</th>
		    <th class="col-sm-3">Description</th>
	        <th>Added</th>
		    <th>Last update</th>
		    <th colspan="2" class="col-sm-1"></th>
		  </tr>
	  </thead>
  <tbody>
	  <c:forEach items="${categories}" var="category">
		  <tr>
		    <td><c:out value="${category.name}" /></td>
		     <td><c:out value="${category.description}"/></td>
		     <td><c:out value="${category.createdDate}"/></td>
		     <td><c:out value="${category.updatedDate}"/></td>
		     <td><a href='<spring:url value="/categories/edit/${category.id}.html"/>'><button class="btn btn-xs btn-default"><span class="glyphicon glyphicon-edit"></span></button></a></td>
		     <td>
			 	<button type="submit" class="btn btn-cicle btn-xs btn-danger triggerRemove" href="/manage/categories/delete/${category.id}.html">x</button>
		     </td>
		  </tr>
	   </c:forEach>
  </tbody>
</table>
 <div class="modal fade" id="modalRemove">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Delete Category</h4>
      </div>
      <div class="modal-body">
        <p>Are you user you want to delete this items?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a  class="btn btn-danger removeBtn" href="">Delete</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
