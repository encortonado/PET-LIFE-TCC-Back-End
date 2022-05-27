package br.com.bortolo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PetImage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "petId", unique = true, nullable = false)
	private Integer petId;

	@Column(columnDefinition = "text")
	private String base64;

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

}
