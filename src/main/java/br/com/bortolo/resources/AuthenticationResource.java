package br.com.bortolo.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bortolo.domain.Authenticate;
import br.com.bortolo.domain.AuthenticateResponse;
import br.com.bortolo.domain.Usuario;
import br.com.bortolo.service.UsuarioService;

@RestController
public class AuthenticationResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/authentication/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticateResponse login(@RequestBody Authenticate auth) {

		System.out.println("");
		logger.info("___________Authentication area___________");
		try {

			Usuario usuario = usuarioService.findFirstByEmailAndPassword(auth.getEmail().toLowerCase(),
					auth.getPassword());

			if (usuario != null) {
				logger.info("Authentication Successful " + usuario.getEmail());
				return new AuthenticateResponse(true, "Authentication Successful " + usuario.getNome().toUpperCase(),
						false, usuario.getNome().toUpperCase(), usuario.getEmail().toUpperCase());
			}

		} catch (Exception e) {
			logger.info("Authentication Fail " + e);
			return new AuthenticateResponse(false, "Authentication Fail " + e, true, "", "");
		}

		logger.info("Authentication Fail. Nenhum usuário encontrado");
		return new AuthenticateResponse(false, "Authentication Fail. Nenhum usuário encontrado", false, "", "");
	}

}
