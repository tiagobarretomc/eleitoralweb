<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@page contentType="text/html; charset=UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {

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

		$('.selectpicker').selectpicker({});

		$('.crudaddbtn').click(function() {
			$(".crudform").submit();
		});
		$('.crudcancelbtn').click(function() {
		});
		$('.crudnewbtn').click(function() {
			$(".crudform").submit();
		});
	});
</script>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="page-header">
				<h1>
					<tiles:getAsString name="title" />
				</h1>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<form id="formCrud"
				name="formCrud" method="post">
				<tiles:insertAttribute name="form.fields" />
				<div class="row">
					<div class="col-md-1">
						<button type="button" id="btncancel"
							class="btn btn-default btn-md crudnewbtn">
							<span class="glyphicon glyphicon-remove"></span>Novo
						</button>
					</div>
					<div class="col-md-1">
						<button type="button" id="btnadd"
							class="btn btn-default btn-md crudaddbtn">
							<span class="glyphicon glyphicon-floppy-disk"></span>Gravar
						</button>
					</div>
					<div class="col-md-1">
						<button type="button" id="btncancel"
							class="btn btn-default btn-md crudcancelbtn">
							<span class="glyphicon glyphicon-remove"></span> Cancelar
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>

