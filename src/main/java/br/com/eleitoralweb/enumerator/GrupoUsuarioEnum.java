package br.com.eleitoralweb.enumerator;

public enum GrupoUsuarioEnum {
	ADMINISTRADOR(1), FINANCEIRO(2), COMERCIAL(3), FORNECEDOR(4), OPERACIONAL(5);
	private int codigo;
	
	GrupoUsuarioEnum(int codigo){
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}

	
}
