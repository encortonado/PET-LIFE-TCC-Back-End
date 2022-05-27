package br.com.bortolo.resources;

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

import br.com.bortolo.domain.PetImage;
import br.com.bortolo.domain.UserImage;
import br.com.bortolo.repository.PetImageRepository;
import br.com.bortolo.repository.UserImageRepository;

@RestController
public class ImageProfileResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserImageRepository userImageRepository;

	@Autowired
	private PetImageRepository petImageRepository;

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/saveUserImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUserImage(@RequestBody UserImage userImage) {

		logger.info("Salvando nova image UserId: " + userImage.getUserId());

		try {

			userImage.setBase64(userImage.getBase64().replace("data:image/*;charset=utf-8", "data:image/jpg"));
			userImageRepository.save(userImage);

			logger.info("Imagem salva com sucesso");
			return new ResponseEntity<>(new Gson().toJson("Imagem salva com sucesso"), HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao salvar imagem. " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao salvar imagem. " + e), HttpStatus.OK);
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getUserImageByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserImage getUserImageByUserId(@PathVariable("userId") Integer userId) {

		logger.info("Resgatando imagem do userId: " + userId);

		try {

			UserImage userImage = userImageRepository.findByUserId(userId);

			if (userImage == null) {
				userImage = new UserImage();
				return userImage;
			}

			userImage.setBase64(userImage.getBase64().replace("\n", "").replace("\r", ""));

			return userImage;

		} catch (Exception e) {
			logger.info("Ocorreu erro ao recuperar imagem. " + e);
			throw e;
		}

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/savePetImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> savePetImage(@RequestBody PetImage petImage) {

		logger.info("Salvando nova image do PetId: " + petImage.getPetId());

		try {

			petImage.setBase64(petImage.getBase64().replace("data:image/*;charset=utf-8", "data:image/jpg"));
			petImageRepository.save(petImage);

			logger.info("Imagem salva com sucesso");
			return new ResponseEntity<>(new Gson().toJson("Imagem salva com sucesso"), HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao salvar imagem. " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao salvar imagem. " + e), HttpStatus.OK);
		}

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getPetImageByPetId/{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PetImage getPetImageByPetId(@PathVariable("petId") Integer petId) {

		logger.info("Resgatando imagem do petId: " + petId);

		try {

			PetImage petImage = petImageRepository.findByPetId(petId);

			if (petImage == null) {
				petImage = new PetImage();
				return petImage;
			}

			petImage.setBase64(petImage.getBase64().replace("\n", "").replace("\r", ""));

			return petImage;

		} catch (Exception e) {
			logger.info("Ocorreu erro ao recuperar imagem. " + e);
			throw e;
		}

	}

}
