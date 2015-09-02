package br.com.eleitoralweb.bean;

public enum TipoCadastroEnum  {
	PARTIDO(1,"Partido"), CANDIDADO(2,"Candidato"), COMITE_FINANCEIRO(3,"Comitê financeiro");
	private int codigo;
	private String descricao;
	TipoCadastroEnum(int codigo, String descricao){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}
	public int getCodigo() {
		return codigo;
	}
	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
