package br.com.bortolo.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.bortolo.domain.Pet;
import br.com.bortolo.service.PetService;

@RestController
public class PetResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PetService petService;

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/savePet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> novoPet(@Valid @RequestBody Pet pet) {

		logger.info("Cadastrando novo Pet: " + pet);

		try {

			String messages = pet.validarPet(pet);

			if (!"".equals(messages)) {
				return new ResponseEntity<>(new Gson().toJson(messages), HttpStatus.BAD_REQUEST);
			}

			petService.save(pet);

			logger.info("Cadastro de Pet realizado com sucesso");
			return new ResponseEntity<>(new Gson().toJson("Cadastro de Pet realizado com sucesso"), HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao cadastrar o Pet. " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao cadastrar o Pet. " + e), HttpStatus.OK);
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getPets", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pet> getPets() {

		logger.info("Resgatando todos os Pets!");

		try {

			return petService.findAll();

		} catch (Exception e) {
			logger.info("Ocorreu erro ao recuperar os Pets. " + e);
			return new ArrayList<Pet>();
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getPetByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pet> getPetsByUserId(@PathVariable("userId") Integer userId) {

		logger.info("Resgatando todos os Pets do userId: " + userId);

		try {

			if (userId == null) {
				return new ArrayList<Pet>();
			}

			return petService.findByUserId(userId);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao recuperar anúncios. " + e);
			return new ArrayList<Pet>();
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/deletePet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deletePet(@PathVariable("id") Integer id) {

		logger.info("Excluindo Pet id: " + id);

		try {

			Pet Pet = new Pet();
			Pet.setId(id);

			petService.delete(Pet);
			return new ResponseEntity<>(new Gson().toJson("Pet ID " + id + " excluído com sucesso!"), HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao excluir o Pet id. " + id + " ERROR: " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao excluir Pet ID " + id + " ERROR: " + e),
					HttpStatus.BAD_REQUEST);

		}

	}

}
