package br.com.eleitoralweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class DadosBancario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Banco banco;
	private String agencia;
	private String conta;
	private Date dataAbertura;
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	

}
