<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<input type="hidden" id="usuariolId" name="bean.id" value="${bean.id}" />
<input type="hidden" id="senhaInicial" name="bean.senhaInicial"
	value="${bean.senhaInicial}" />
<input type="hidden" id="senha" name="bean.senha" value="${bean.senha}" />


<div class="row-fluid">
	<div class="col-sm-4">
		<label for="bean.nome">Nome:</label> <input name="bean.nome"
			id="bean.nome" value="${bean.nome}" class="form-control required"
			size="8" maxlength="45" />
	</div>

	<div class="col-sm-4">
		<label for="bean.email">E-mail:</label> <input name="bean.email"
			id="bean.email" value="${bean.email}" class="form-control required"
			size="45" maxlength="45" />
	</div>
	<div class="col-sm-4">
		<label for="bean.nome">Login:</label> <input name="bean.login"
			id="bean.login" value="${bean.login}" class="form-control required"
			size="8" maxlength="15" />
	</div>
</div>
<br/><br/><br/><br/>
<div class="row-fluid">
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">Grupos</div>
		<div class="panel-body">
				<label for="grupo">Grupo:</label> <select id="grupo" name="grupo"
					class="selectpicker form-control" data-live-search="true">
					<option value="">Selecione</option>
					<c:forEach var="grupo" items="${gruposUsuarios}"
						varStatus="contador">
						<option value="${grupo}">${grupo}</option>
					</c:forEach>
				</select>
				<button type="button" id="btnAdicionarGrupo"
					class="btn btn-default btn-md">
					<span class="glyphicon glyphicon-floppy-disk"></span> Adicionar
				</button>
			<!-- List group -->
			<div id="grupoList" style="clear: both;">
				<ul class="list-group">
					<c:forEach var="grupoUsuario" items="${gruposDoUsuario}"
						varStatus="contador">
						<li class="list-group-item"><span
							id="removerGrupo_${contador.index}" title="Excluir"
				  					class="glyphicon glyphicon-remove">
								${grupoUsuario.nome} </span><input type="hidden"
							id="grupos[${contador.index}]" name="grupos[${contador.index}]"
							value="${grupoUsuario}" /></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>