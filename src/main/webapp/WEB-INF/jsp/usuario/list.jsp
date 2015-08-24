<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<table class="table table-bordered table-striped">

	<thead>
		<tr>
			<th></th>
			<th>Nome</th>
			<th>E-mail</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="bean" items="${beanList}" varStatus="contador">

			<tr>
				<td><a href="${pageContext.request.contextPath}/usuario/${bean.id}"><span
						title="Alterar" class="glyphicon glyphicon-edit"></span></a> <a
					href="<c:url value='/usuario/remove/'/>${bean.id}"><span
						title="Excluir" class="glyphicon glyphicon-remove"></span></a></td>
				<td>${bean.nome}</td>
				<td>${bean.email}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>