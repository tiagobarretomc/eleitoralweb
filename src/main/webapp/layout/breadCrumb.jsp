<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tilesx:useAttribute id="breadcrumbs" name="breadcrumbs" classname="java.util.List" />
<tilesx:useAttribute id="breadcrumbslinks" name="breadcrumbslinks" classname="java.util.List" />

<ul class="breadcrumb">
<c:forEach var="itemBreadcrumb" varStatus="index" items="${breadcrumbs}">
<c:if test="${index.index eq breadcrumbs.size()-1}">
	<li class="active">${ itemBreadcrumb}</li>
</c:if>
<c:if test="${index.index lt breadcrumbs.size()-1}">
	<li><a href="${pageContext.request.contextPath}${breadcrumbslinks[index.index]}">${itemBreadcrumb}</a></li>
</c:if>	
</c:forEach>
</ul>