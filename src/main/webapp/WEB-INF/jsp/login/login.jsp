<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
	$(document).ready(function() {

		$("#btnlogin").click(function() {
			$("#formLogin").submit();
		});

		$('#formLogin').validate({

		});

	});
</script>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-xs-12">

			<div class="form-login">
				<h2></h2>
				<form action="<c:url value='/autenticar'/>" id="formLogin"
					name="formLogin" method="post">

					<span class="error">${errors.from('login')}</span>
					<label class="sr-only" for="login">Login:</label> <input
						name="login" id="login" class="form-control input-lg required"
						placeholder="Seu login" maxlength="50" required /> 
						<label
						class="sr-only" for="senha">Senha:</label> <input
						type="password" id="senha" name="senha"
						class="form-control input-lg required" placeholder="Sua senha"
						maxlength="15" required />

					<div class="checkbox">
						<label> <input type="checkbox" value="s" /> Lembre-me
						</label>
					</div>

					<button type="submit" class="btn btn-primary btn-lg btn-block" id="btnlogar">
						<span class="glyphicon glyphicon-ok"></span> Acessar
					</button>
				</form>
			</div>
		</div>
	</div>
</div>