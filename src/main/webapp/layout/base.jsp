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
<link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/theme-bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">

<link href="${pageContext.request.contextPath}/css/estilo.css"
	rel="stylesheet">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <script	src="${pageContext.request.contextPath}/js/jquery.min.1.11.0.js"></script>
</head>

<body>

	<tiles:insertAttribute name="layout.top" />
	<div class="container-fluid">
		<div class="row-fluid">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<script	src="${pageContext.request.contextPath}/js/jquery.min.1.11.0.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootbox.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.maskedinput.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.price_format.2.0.min.js" /></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/date.js" /></script>
		<script type="text/javascript">
		
		$(document).ready(function() {
			alert($('[form]').length);
			$('[form]').validate({
	        	ignore: ':not(select:hidden, input:visible, textarea:visible)',
	            errorPlacement: function (error, element) {
	                if ($(element).is('select')) {
	                    element.next().after(error); // special placement for select elements
	                } else {
	                    error.insertAfter(element);  // default placement for everything else
	                }
	            }
	        
	    	});
			$(".datepicker").datepicker({
				format : "dd/mm/yyyy",
				endDate : "-2d"
			})

			$(".datepicker").mask('99/99/9999');

			$(".price").priceFormat({
				prefix : '',
				centsSeparator : ',',
				thousandsSeparator : '.',
				limit : 12

			});

			$('.selectpicker').selectpicker({
			//'selectedText': 'cat'
			});

			var options = new Array();
			options['language'] = 'pt-BR';
			$('.datepicker').datepicker(options);

		});
	</script>
</body>
</html>