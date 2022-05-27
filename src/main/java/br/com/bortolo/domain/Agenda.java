package br.com.bortolo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "agenda_generator")
	@SequenceGenerator(name = "agenda_generator", sequenceName = "agenda_generator", initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	private Integer anuncioId;
	private Integer anuncianteId;
	private Integer clienteId;
	private Integer petId;

	private String userNameAnuncio;
	private String userNameCliente;

	private Date dataCadastro;
	private String serviceName;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	private String horario;

	private String formaPagamento;
	private String preco;

	private Boolean isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnuncioId() {
		return anuncioId;
	}

	public void setAnuncioId(Integer anuncioId) {
		this.anuncioId = anuncioId;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Integer getAnuncianteId() {
		return anuncianteId;
	}

	public void setAnuncianteId(Integer anuncianteId) {
		this.anuncianteId = anuncianteId;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUserNameAnuncio() {
		return userNameAnuncio;
	}

	public void setUserNameAnuncio(String userNameAnuncio) {
		this.userNameAnuncio = userNameAnuncio;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getUserNameCliente() {
		return userNameCliente;
	}

	public void setUserNameCliente(String userNameCliente) {
		this.userNameCliente = userNameCliente;
	}

}
