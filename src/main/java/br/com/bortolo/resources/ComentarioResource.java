package br.com.bortolo.resources;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bortolo.domain.Comentario;
import br.com.bortolo.repository.ComentarioRepository;

@RestController
public class ComentarioResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ComentarioRepository comentarioRepository;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getComentariosByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comentario> getPetsByUserId(@PathVariable("userId") Integer userId) {

		logger.info("Resgatando todos os comentarios do userId: " + userId);

		try {

			if (userId == null) {
				return new ArrayList<Comentario>();
			}

			return comentarioRepository.findByUserIdOrderByDataCadastroDesc(userId);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao recuperar os comentarios. " + e);
			return new ArrayList<Comentario>();
		}

	}

}
