package br.com.bortolo.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import br.com.bortolo.domain.Usuario;
import br.com.bortolo.dto.UsuarioDTO;
import br.com.bortolo.service.PetService;
import br.com.bortolo.service.UsuarioService;
import br.com.bortolo.utils.StringFormatter;

@RestController
public class UsuarioResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PetService petService;

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestBody UsuarioDTO user) {

		logger.info("Registrando novo usuário! " + user.getNome());

		try {

			String messages = user.validarUsuarioDTO(user);

			if (!"".equals(messages)) {
				return new ResponseEntity<>(new Gson().toJson(messages), HttpStatus.BAD_REQUEST);
			}

			user.setEmail(user.getEmail().toLowerCase());
			user.setNome(StringFormatter.capitalizeWord(user.getNome()));
			Usuario usuario = usuarioService.findFirstByEmail(user.getEmail());

			if (usuario == null) {
				usuarioService.save(user);

				logger.info("Registro realizado com sucesso. Bem vindo" + user.getNome());
				return new ResponseEntity<>(
						new Gson().toJson("Registro realizado com sucesso. Bem vindo  " + user.getNome()),
						HttpStatus.OK);
			} else {
				logger.info("Email " + user.getEmail() + " Já cadastrado!");
				return new ResponseEntity<>(new Gson().toJson("Email " + user.getEmail() + " Já cadastrado!"),
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			logger.info("Ocorreu erro ao registrar. " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao registrar. " + e), HttpStatus.OK);
		}

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody UsuarioDTO user) {

		logger.info("Atualizando usuario! " + user.getNome());

		try {

			String messages = user.validarUsuarioDTO(user);

			if (!"".equals(messages)) {
				return new ResponseEntity<>(new Gson().toJson(messages), HttpStatus.BAD_REQUEST);
			}

			user.setEmail(user.getEmail().toLowerCase());
			user.setNome(StringFormatter.capitalizeWord(user.getNome()));

			usuarioService.save(user);

			logger.info("Registro realizado com sucesso. Bem vindo" + user.getNome());
			return new ResponseEntity<>(new Gson().toJson("Usuario atualizado com sucesso. UserName:" + user.getNome()),
					HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao atualizar usuario. " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao atualizar usuario. " + e), HttpStatus.OK);
		}

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/findUserByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findUserByEmail(@RequestBody String email) {

		logger.info("Buscando usuário por email: " + email);

		try {

			Usuario usuario = usuarioService.findFirstByEmail(email.toLowerCase());

			if (usuario == null) {

				logger.info("Nenhum usuário encontrado com o email: " + email);
				return new Usuario();
			}

			return usuario;

		} catch (Exception e) {
			logger.info("Ocorreu erro ao buscar usuário pelo email: . " + email + e);
			return new Usuario();
		}

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/findUserById", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findUserById(@RequestBody Integer userId) {

		logger.info("Buscando usuário por Id: " + userId);

		try {

			Usuario usuario = usuarioService.findUserById(userId);

			if (usuario == null) {

				logger.info("Nenhum usuário encontrado com o Id: " + userId);
				return new Usuario();
			}

			return usuario;

		} catch (Exception e) {
			logger.info("Ocorreu erro ao buscar usuário pelo Id: . " + userId + e);
			return new Usuario();
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/findUserAndPetById/{userId}/{petId}/{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findUserAndPetById(@PathVariable("userId") Integer userId,
			@PathVariable("petId") Integer petId, @PathVariable("clienteId") Integer clienteId) {

		logger.info("Buscando anunciante Id: " + userId + " e Pet id " + petId);

		Map<String, Object> anunciantePet = new HashMap<>();

		try {

			Usuario anunciante = usuarioService.findUserById(userId);
			Usuario cliente = usuarioService.findUserById(clienteId);

			if (cliente == null) {

				logger.info("Nenhum cliente encontrado com o Id: " + clienteId);
				cliente = new Usuario();
			}

			if (anunciante == null) {

				logger.info("Nenhum usuário encontrado com o Id: " + userId);
				anunciante = new Usuario();
			}

			Pet pet = petService.findPetById(petId);

			if (pet == null) {

				logger.info("Nenhum pet encontrado com o Id: " + petId);
				pet = new Pet();
			}

			anunciantePet.put("pet", pet);
			anunciantePet.put("anunciante", anunciante);
			anunciantePet.put("cliente", cliente);

			return anunciantePet;

		} catch (Exception e) {
			logger.info("Ocorreu erro ao buscar usuário pelo Id: . " + userId + e);
			return anunciantePet;
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getAllCities", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllCities() {

		try {

			List<String> cities = usuarioService.getAllCities();
			return cities;

		} catch (Exception e) {
			return new ArrayList<String>();
		}

	}

}
