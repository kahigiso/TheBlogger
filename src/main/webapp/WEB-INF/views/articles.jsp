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
<ul class="breadcrumb"><li>Manage</li><li>Articles</li></ul>
<c:if test="${SUCCESS_MESSAGE != null}">
  <div class="alert alert-success" role="alert"><c:out value="${SUCCESS_MESSAGE}"/></div>
</c:if> 
<c:if test="${FAILED_MESSAGE != null}">
  <div class="alert alert-danger" role="alert"><c:out value="${FAILED_MESSAGE}"/></div>
</c:if> 
<!-- Button trigger modal -->
<a class="btn btn-primary btn-sm" href="/manage/articles/addArticle.html">
  New Article
</a>
 <table class="table table-hover table-striped table-condensed">
	 <thead>
		  <tr>
		    <th class="col-sm-2">Title</th>
		    <th>Category</th>
		    <th>Added</th>
		    <th>Last update</th>
		    <th colspan="2" class="col-sm-1"></th>
		  </tr>
	  </thead>
    <tbody>
	  <c:forEach items="${pages.content}" var="article">
		  <tr>
		    <td><c:out value="${article.title}" /></td>
		     <td><c:out value="${article.category.name}"/></td>
		     <td><c:out value="${article.createdDate}"/></td>
		     <td><c:out value="${article.updatedDate}"/></td>
		     <td><a href='<spring:url value="/manage/articles/edit/${article.id}.html"/>'><button class="btn btn-xs btn-default"><span class="glyphicon glyphicon-edit"></span></button></a></td>
		     <td>
				<a class="btn btn-cicle btn-xs btn-danger triggerRemove" href="/manage/articles/delete/${article.id}.html">x</a>
		     </td>
		  </tr>
	   </c:forEach>
    </tbody>
</table>
  <c:url var="firstUrl" value="/manage/articles.html?p=1" />
  <c:url var="lastUrl" value="/manage/articles.html?p=${pages.totalPages}" />
  <c:url var="prevUrl" value="/manage/articles.html?p=${currentIndex - 1}" />
  <c:url var="nextUrl" value="/manage/articles.html?p=${currentIndex + 1}" />
  <ul class="pagination pagination-sm ">
       <c:choose>
           <c:when test="${currentIndex == 1}">
               <li class="disabled"><a href="#">&lt;&lt;</a></li>
               <li class="disabled"><a href="#">&lt;</a></li>
           </c:when>
           <c:otherwise>
               <li><a href="${firstUrl}">&lt;&lt;</a></li>
               <li><a href="${prevUrl}">&lt;</a></li>
           </c:otherwise>
       </c:choose>
       <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
           <c:url var="pageUrl" value="/manage/articles.html?p=${i}" />
           <c:choose>
               <c:when test="${i == currentIndex}">
                   <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
               </c:when>
               <c:otherwise>
                   <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
               </c:otherwise>
           </c:choose>
       </c:forEach>
       <c:choose>
           <c:when test="${currentIndex == pages.totalPages}">
               <li class="disabled"><a href="#">&gt;</a></li>
               <li class="disabled"><a href="#">&gt;&gt;</a></li>
           </c:when>
           <c:otherwise>
               <li><a href="${nextUrl}">&gt;</a></li>
               <li><a href="${lastUrl}">&gt;&gt;</a></li>
           </c:otherwise>
       </c:choose>
   </ul>
 <div class="modal fade" id="modalRemove">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Delete Article</h4>
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