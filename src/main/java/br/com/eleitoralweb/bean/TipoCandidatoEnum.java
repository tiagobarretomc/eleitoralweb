package br.com.eleitoralweb.bean;

public enum TipoCandidatoEnum {
	PRESIDENTE(1,"Presidente"), GOVERNADOR(2,"Governador"),PREFEITO(3,"Prefeito"),
	SENADOR(4,"Senador"),DEPUTADO_FEDERAL(4,"Deputado federal"), DEPUTADO_ESTADUAL(5, "Deputado estadual"),
	VEREADOR(6, "Vereador");
	
	private int codigo;
	private String descricao;
	TipoCandidatoEnum(int codigo, String descricao){
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
