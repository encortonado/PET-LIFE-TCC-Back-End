package br.com.bortolo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

@Entity
@Table
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "pet_generator")
	@SequenceGenerator(name = "pet_generator", sequenceName = "pet_generator", initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	private Integer userId;
	private String nome;
	private String idade;
	private String peso;
	private String raca;
	private String petType;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String validarPet(Pet pet) {

		String messages = "";

		if (pet.getNome() == null || "".equals(pet.getNome())) {
			messages = messages + "Campo NOME é obrigatório. ";
		}

		if (StringUtils.isEmpty(pet.getDescricao())) {
			messages = messages + "Campo Descrição é obrigatório. ";
		}

		if (StringUtils.isEmpty(pet.getIdade())) {
			messages = messages + "Campo Idade é obrigatório. ";
		}

		if (StringUtils.isEmpty(pet.getPeso())) {
			messages = messages + "Campo Peso é obrigatório. ";
		}
		if (StringUtils.isEmpty(pet.getRaca())) {
			messages = messages + "Campo Raça é obrigatório. ";
		}

		return messages;

	}

}
