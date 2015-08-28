<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	< class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/"><tiles:getAsString name="title" />${userSession.user}</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->

	<c:if test="${not empty userSession.user}">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><i
						class="fa fa-user fa-2x"></i> <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Minha Conta</a></li>
						<li><a href="#">Trocar Senha</a></li>
						<li class="divider"></li>
						<li><a href="#">Efetuar Logoff</a></li>
					</ul></li>
			</ul>
		</div>
	</c:if>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>