<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$('.nav-tabs a:first').tab('show');
	})
</script>
<c:if test="${SUCCESS_MESSAGE != null}">
  <div class="alert alert-success" role="alert"><c:out value="${SUCCESS_MESSAGE}"/></div>
</c:if> 
<c:if test="${FAILED_MESSAGE != null}">
  <div class="alert alert-danger" role="alert"><c:out value="${FAILED_MESSAGE}"/></div>
</c:if> 
   <div class="row">
       <div class="col-lg-12">
        <a type="button" class="btn btn-primary" href="/index/pages/0.html?p=1">Latest</a>
        <c:forEach items="${categories}" var="cat">
           <a type="button" class="btn btn-primary" href="/index/pages/${cat.id}.html?p=1"><c:out value="${cat.name}"/></a>
        </c:forEach>
        <form class="navbar-form navbar-right" role="search" action="/index/search">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="Search">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
       </div>
       <div class="col-lg-12"><h4></h4></div>
   </div>
   
  <c:forEach items="${pages.content}" var="article">
	  <div class ="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title"><c:out value="${article.title}"/></h3></div>
			<div class="panel-body">
		  		<c:set var="msg" value="${fn:substring(article.content, 0, 1000)}" />
		     	<c:out value="${msg}"/>
		  		<a href="/articles/read/${article.id}.html" >Read more...</a>
		  </div>
		  <div class="panel-footer clearfix">
	        <div class="pull-right">
	            <a href="/comments/add/${article.id}.html" >Sent Comment</a>
	      	</div>
    	</div>
	  </div>
  </c:forEach>
  <c:url var="firstUrl" value="/index/pages/${(category==null)?0:category.id}.html?p=1" />
  <c:url var="lastUrl" value="/index/pages/${(category==null)?0:category.id}.html?p=${pages.totalPages}" />
  <c:url var="prevUrl" value="/index/pages/${(category==null)?0:category.id}.html?p=${currentIndex - 1}" />
  <c:url var="nextUrl" value="/index/pages/${(category==null)?0:category.id}.html?p=${currentIndex + 1}" />

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
            <c:url var="pageUrl" value="/index/pages/${(category==null)?0:category.id}.html?p=${i}" />
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