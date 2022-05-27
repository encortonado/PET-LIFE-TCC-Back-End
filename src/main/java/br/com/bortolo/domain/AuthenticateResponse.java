package br.com.bortolo.domain;

public class AuthenticateResponse {

	public AuthenticateResponse(Boolean authenticate, String message, Boolean error, String nome, String email) {
		this.authenticate = authenticate;
		this.message = message;
		this.error = error;
		this.nome = nome;
		this.email = email;
	}

	private Boolean authenticate;
	private String message;
	private Boolean error;
	private String nome;
	private String email;

	public Boolean getAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(Boolean authenticate) {
		this.authenticate = authenticate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
