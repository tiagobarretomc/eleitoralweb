<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html; charset=UTF-8"%>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:getAsString name="title" /></title>

<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700'
	rel='stylesheet' type='text/css'>
<link
	href="${pageContext.request.contextPath}/css/theme-bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">

<link href="${pageContext.request.contextPath}/css/estilo.css"
	rel="stylesheet">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<fmt:setLocale value="pt_br" />

<body>
	<tiles:insertAttribute name="menu.top" />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-3">
				<tiles:insertAttribute name="menu.left" />
			</div>
			<div class="col-sm-9">

				<div class="conteudo_painel">
					<div class="conteudo_painel_int">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>