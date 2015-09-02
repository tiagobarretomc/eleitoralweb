<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script>
	var estadoList = $
	{
		estadoList
	};
	carregarCombo($('#estado'), estadoList);
</script>
<input type="hidden" id="campanhaId" name="bean.id" value="${bean.id}" />
<div class="row-fluid">
	<div class="col-sm-2">
		<label for="bean.ano">Ano eleitoral:</label>
		<div class="input-group spinner">
			<input id="bean.ano" type="text" name="bean.ano"
				class="required form-control" value="${bean.ano}">
			<div class="input-group-btn-vertical">
				<button class="btn btn-default" type="button">
					<i class="fa fa-caret-up"></i>
				</button>
				<button class="btn btn-default" type="button">
					<i class="fa fa-caret-down"></i>
				</button>
			</div>
		</div>

	</div>
	<div class="col-sm-4">
		<label for="estado">Estado:</label> <select id="estado"
			name="bean.estado.id" class="required form-control selectpicker"
			data-live-search="true">
		</select>
	</div>
	<div class="col-sm-4">
		<label for="estado">Estado:</label> <select id="estado"
			name="bean.estado.id" class="required form-control selectpicker"
			data-live-search="true">
		</select>
	</div>
	<c:if test="">
		<div class="col-sm-4">
			<label for="cidade">Cidade:</label> <select id="cidade"
				name="bean.cidade.id" class="required form-control selectpicker"
				data-live-search="true">
			</select>
		</div>
	</c:if>
	<div class="col-sm-4"></div>
</div>
