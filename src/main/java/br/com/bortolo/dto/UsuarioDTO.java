package br.com.bortolo.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioDTO {

	private Integer id;
	private String nome;
	private String email;
	private String password;
	private Date dataNascimento;
	private Date dataCadastro;
	private Date dataAtualizacao;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String numero;
	private Integer rate;
	private Integer ddd;
	private Integer telefone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String validarUsuarioDTO(UsuarioDTO user) {

		String messages = "";

		String regex = "^[\\w+.]+@\\w+\\.\\w{2,}(?:\\.\\w{2})?$";

		if (user.getEmail() == null || "".equals(user.getEmail())) {
			messages = messages + "Campo EMAIL ?? obrigat??rio. ";
		} else if (!user.getEmail().matches(regex)) {
			messages = messages + "Campo EMAIL est?? com formato incorreto. ";
		}

		if (user.getNome() == null || "".equals(user.getNome())) {
			messages = messages + "Campo NOME ?? obrigat??rio. ";
		}

		if (user.getPassword() == null || "".equals(user.getPassword())) {
			messages = messages + "Campo PASSWORD ?? obrigat??rio. ";
		}

		if (user.getDataNascimento() == null) {
			messages = messages + "O campo Data de Nacismento ?? obrigat??rio. ";
		}

		if (user.getBairro() == null) {
			messages = messages + "O campo Bairro ?? obrigat??rio. ";
		}

		if (user.getCep() == null) {
			messages = messages + "O campo CEP ?? obrigat??rio. ";
		}

		if (user.getCidade() == null) {
			messages = messages + "O campo Cidade ?? obrigat??rio. ";
		}

		if (user.getDataCadastro() == null) {
			messages = messages + "O campo Data de Cadastro ?? obrigat??rio. ";
		}

		if (user.getEstado() == null) {
			messages = messages + "O campo Estado ?? obrigat??rio. ";
		}

		if (user.getLogradouro() == null) {
			messages = messages + "O campo Logradouro ?? obrigat??rio. ";
		}

		if (user.getNumero() == null) {
			messages = messages + "O campo Numero ?? obrigat??rio. ";
		}

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String data = sdf.format(user.getDataNascimento());
			user.setDataNascimento(sdf.parse(data));

		} catch (Exception e) {

			messages = messages
					+ "Ocorreu erro ao tratar do campo DATA NASCIMENTO. Por favor verifique se est?? no Formato esperado: yyyy-MM-dd";

		}

		return messages;
	}

}
