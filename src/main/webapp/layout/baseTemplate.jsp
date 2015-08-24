<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="col-sm-3">
	<tiles:insertAttribute name="layout.menu" />
</div>
<div class="col-sm-9">

	<div class="conteudo_painel">
		<div class="conteudo_painel_int">
			<tiles:insertAttribute name="content" />
		</div>
	</div>
</div>