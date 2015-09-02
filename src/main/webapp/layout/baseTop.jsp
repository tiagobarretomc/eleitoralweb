<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<img class="navbar-brand"
				src="${pageContext.request.contextPath}/images/bandeira_todos-os-estados.jpg"
				> 
			<img class="navbar-brand"
				src="${pageContext.request.contextPath}/images/45px-Bandeira_de_Sergipe.svg.png">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">
				<tiles:getAsString name="title" />
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->

		<c:if test="${not empty userSession.user}">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-user fa-2x"></i> <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/campanhaEleitoral/form">Cadastro</a></li>
							<li><a href="#">Trocar Senha</a></li>
							<li class="divider"></li>
							<li><a href="#">Efetuar Logoff</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</c:if>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>