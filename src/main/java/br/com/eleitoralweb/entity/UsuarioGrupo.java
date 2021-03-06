package br.com.eleitoralweb.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="usuario_grupo")
public class UsuarioGrupo {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	@XmlTransient
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grupo")
	private GrupoUsuario grupoUsuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}
	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}
	
}
