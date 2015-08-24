<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".crudfilterbtn")
								.click(
										function() {

											$(".searchtable")
													.load(
															'${pageContext.request.contextPath}/<tiles:getAsString name="controller" />/filtrar',
															$('.crudsearchform')
																	.serialize());
										});
						$(".crudnewbtn").click(function(){
							
				    			document.location.href = "${pageContext.request.contextPath}/<tiles:getAsString name="controller" />/novo";
				    	});
						$('.selectpicker').selectpicker({
						//'selectedText': 'cat'
						});
					});
</script>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="page-header">
			<h1>
				<tiles:getAsString name="title" />
			</h1>
		</div>
		<button type="button" id="btnnew"
			class="btn btn-default btn-md crudnewbtn">
			<span class="glyphicon glyphicon-plus-sign"></span> Adicionar
		</button>
		<div class="panel panel-default">
			<div class="panel-body">
				<form id="searchform" name="searchform" method="post">
					<input type="hidden" name="_format" value="json">
					<tiles:insertAttribute name="search.form" />
					<br />
					<button id="btnfilter" type="button"
						class="btn btn-default btn-sm crudfilterbtn">
						<span class="glyphicon glyphicon-filter"></span> Filtrar
					</button>
					<button id="btnclear" type="button"
						class="btn btn-default btn-sm crudclearbtn">
						<span class="glyphicon glyphicon-filter"></span> Limpar
					</button>
				</form>
			</div>
		</div>
	</div>
	<div class="conteudo_painel">
		<div class="conteudo_painel_int">
			<div class="row-fluid">
				<tiles:insertAttribute name="search.list" />
			</div>

		</div>
	</div>

</div>
