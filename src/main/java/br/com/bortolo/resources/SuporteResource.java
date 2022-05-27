package br.com.bortolo.resources;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.bortolo.domain.Agenda;
import br.com.bortolo.domain.Suporte;
import br.com.bortolo.domain.Usuario;
import br.com.bortolo.dto.ServiceDTO;
import br.com.bortolo.repository.AgendaRepository;
import br.com.bortolo.repository.SuporteRepository;
import br.com.bortolo.service.UsuarioService;

@RestController
public class SuporteResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SuporteRepository suporteRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AgendaRepository agendaRepository;

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/relatarProblema", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> finalizarAnuncio(@RequestBody ServiceDTO service) {

		logger.info("Cadastrando problema");

		try {

			Suporte suporte = new Suporte();

			suporte.setAgendaId(Integer.parseInt(service.getAgendaId()));
			suporte.setDescricao(service.getComentario());

			Agenda agenda = agendaRepository.findById(Integer.parseInt(service.getAgendaId()));
			Usuario user = usuarioService.findUserById(agenda.getClienteId());

			suporte.setAnuncianteId(agenda.getAnuncianteId());

			suporte.setUserReported(service.getUserReported());
			suporte.setUserReporter(service.getUserReporter());
			suporte.setUserId(user.getId());

			suporte.setDataCadastro(new Date());

			suporteRepository.save(suporte);

			logger.info("Problema registrado com sucesso. Agradecemos por utilizar nossos serviços.");
			return new ResponseEntity<>(
					new Gson().toJson("Problema registrado com sucesso. Agradecemos por utilizar nossos serviços."),
					HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Ocorreu erro ao finalizar registrar problema. " + e);
			return new ResponseEntity<>(new Gson().toJson("Ocorreu erro ao finalizar registrar problema. " + e),
					HttpStatus.OK);
		}

	}

}
