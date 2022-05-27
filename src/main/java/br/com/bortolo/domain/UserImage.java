package br.com.bortolo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserImage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userId", unique = true, nullable = false)
	private Integer userId;
	
	@Column(columnDefinition = "text")
	private String base64;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

}
