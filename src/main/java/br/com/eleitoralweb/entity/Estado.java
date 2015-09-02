package br.com.eleitoralweb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="estado")
public class Estado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="cod_ibge")
	private Integer codigoIBGE;
	@Column(name="sigla")
	private String codigo;
	private String nome;
	@OneToMany(mappedBy="estado")
	@Fetch(FetchMode.JOIN)
	private List<Cidade> cidades;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}
	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}
	
	
	

}
