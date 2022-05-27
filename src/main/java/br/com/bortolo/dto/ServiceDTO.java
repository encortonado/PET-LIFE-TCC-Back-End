package br.com.bortolo.dto;

public class ServiceDTO {

	private String agendaId;
	private String anuncianteId;
	private String comentario;
	private String userReported;
	private String userReporter;

	public String getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(String agendaId) {
		this.agendaId = agendaId;
	}

	public String getAnuncianteId() {
		return anuncianteId;
	}

	public void setAnuncianteId(String anuncianteId) {
		this.anuncianteId = anuncianteId;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getUserReported() {
		return userReported;
	}

	public void setUserReported(String userReported) {
		this.userReported = userReported;
	}

	public String getUserReporter() {
		return userReporter;
	}

	public void setUserReporter(String userReporter) {
		this.userReporter = userReporter;
	}

}
