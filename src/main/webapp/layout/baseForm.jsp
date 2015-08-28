<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@page contentType="text/html; charset=UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {

		$('.crudaddbtn').click(function() {
			$(".crudform").attr('action','${pageContext.request.contextPath}/<tiles:getAsString name="controller" />/add');
			$(".crudform").submit();

		});
		$('.crudcancelbtn').click(function() {
			window.location.href = '${pageContext.request.contextPath}/<tiles:getAsString name="controller" />/lista';
		});
		$('.crudnewbtn').click(function() {
			$(".crudform").attr('action','${pageContext.request.contextPath}/<tiles:getAsString name="controller" />/novo');
			$(".crudform").submit();
		});
		$('.crudform').validate({

			ignore: ':not(select:hidden, input:visible, textarea:visible)',

			errorPlacement: function (error, element) {
				if ($(element).is('select')) {
					element.next().after(error); // special placement for select elements
				} else {
					error.insertAfter(element);  // default placement for everything else
				}
			},


		});

	});
</script>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-sm-12">
			<div class="page-header">
				<h1>
					<tiles:getAsString name="title" />
				</h1>
			</div>

			<div class="conteudo_painel">
				<div class="conteudo_painel_int">
					<form id="formCrud" class="crudform" name="formCrud" method="post">
						<tiles:insertAttribute name="form.fields" />
						<button type="button" id="btncancel"
							class="btn btn-default btn-md crudnewbtn">
							<span class="glyphicon glyphicon-remove"></span>Novo
						</button>
						<button type="button" id="btnadd"
							class="btn btn-default btn-md crudaddbtn">
							<span class="glyphicon glyphicon-floppy-disk"></span>Gravar
						</button>
						<button type="button" id="btncancel"
							class="btn btn-default btn-md crudcancelbtn">
							<span class="glyphicon glyphicon-remove"></span> Cancelar
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
