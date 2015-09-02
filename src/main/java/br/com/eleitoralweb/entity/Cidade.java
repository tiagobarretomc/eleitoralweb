package br.com.eleitoralweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	private String nome;
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;
	private boolean capital;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public boolean isCapital() {
		return capital;
	}
	public void setCapital(boolean capital) {
		this.capital = capital;
	}
	
	
	

}
