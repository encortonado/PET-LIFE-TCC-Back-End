package br.com.bortolo.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthApplication {
	/**
	 * Responde 200 se a aplicação já estiver rodando
	 * 
	 * @return status code 200 se a aplicação estiver ok
	 */
	@GetMapping(value = "/")
	public ResponseEntity<Object> health() {

		final Logger logger = LoggerFactory.getLogger(this.getClass());

		try {
			return new ResponseEntity<>("Application Is Runnig!", HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}
}
