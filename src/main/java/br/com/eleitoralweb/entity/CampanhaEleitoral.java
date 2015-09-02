package br.com.eleitoralweb.entity;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.eleitoralweb.bean.TipoCadastroEnum;
import br.com.eleitoralweb.bean.TipoCandidatoEnum;

@Entity
@Table(name="campanha_eleitoral")
public class CampanhaEleitoral implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private int ano;
	@ManyToOne
	@JoinColumn(name="id_estado")
	@NotNull
	private Estado estado;
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="id_tipo")
	private TipoCadastroEnum tipo;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="id_tipo_candidato")
	private TipoCandidatoEnum tipoCandidado;
	@ManyToOne
	@JoinColumn(name="id_legenda")
	private Legenda legenda;
	private String registro;
	private String cnpj;
	@Column(name="dt_abertura_cnpj")
	private Date dataAberturaCnpj;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "agencia", column = @Column(name = "agencia")),
						  @AttributeOverride(name = "conta", column = @Column(name = "conta")),
						  @AttributeOverride(name = "dataAbertura", column = @Column(name = "dt_abertura_conta"))})
	@AssociationOverrides({@AssociationOverride(name= "banco",
    					joinColumns = @JoinColumn(name="id_banco"))})
	private DadosBancario dadosBancario;
	@Column(name="recibo_gerado")
	private boolean reciboLiberado;
	public CampanhaEleitoral() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date());
		this.ano = cal.get(Calendar.YEAR);
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public TipoCadastroEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoCadastroEnum tipo) {
		this.tipo = tipo;
	}
	public TipoCandidatoEnum getTipoCandidado() {
		return tipoCandidado;
	}
	public void setTipoCandidado(TipoCandidatoEnum tipoCandidado) {
		this.tipoCandidado = tipoCandidado;
	}
	public Legenda getLegenda() {
		return legenda;
	}
	public void setLegenda(Legenda legenda) {
		this.legenda = legenda;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataAberturaCnpj() {
		return dataAberturaCnpj;
	}
	public void setDataAberturaCnpj(Date dataAberturaCnpj) {
		this.dataAberturaCnpj = dataAberturaCnpj;
	}
	public DadosBancario getDadosBancario() {
		return dadosBancario;
	}
	public void setDadosBancario(DadosBancario dadosBancario) {
		this.dadosBancario = dadosBancario;
	}
	public boolean isReciboLiberado() {
		return reciboLiberado;
	}
	public void setReciboLiberado(boolean reciboLiberado) {
		this.reciboLiberado = reciboLiberado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
