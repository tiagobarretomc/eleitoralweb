package br.com.eleitoralweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import br.com.eleitoralweb.enumerator.GrupoUsuarioEnum;

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
	
	@Column(name="grupo")
	@Enumerated(EnumType.STRING)
	private GrupoUsuarioEnum grupoUsuario;
	
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
	public GrupoUsuarioEnum getGrupoUsuario() {
		return grupoUsuario;
	}
	public void setGrupoUsuario(GrupoUsuarioEnum grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}
	
}
