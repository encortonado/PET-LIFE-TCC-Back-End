package br.com.bortolo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Suporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "suporte_generator")
	@SequenceGenerator(name = "suporte_generator", sequenceName = "suporte_generator", initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	private Integer agendaId;
	private Integer anuncianteId;
	private Integer userId;
	private String userReporter;
	private String userReported;
	private String descricao;
	private String resolucao;
	private Date dataCadastro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getAnuncianteId() {
		return anuncianteId;
	}

	public void setAnuncianteId(Integer anuncianteId) {
		this.anuncianteId = anuncianteId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserReporter() {
		return userReporter;
	}

	public void setUserReporter(String userReporter) {
		this.userReporter = userReporter;
	}

	public String getUserReported() {
		return userReported;
	}

	public void setUserReported(String userReported) {
		this.userReported = userReported;
	}

}
