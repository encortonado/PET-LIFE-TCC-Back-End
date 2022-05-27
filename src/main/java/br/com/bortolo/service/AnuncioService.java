package br.com.bortolo.service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bortolo.domain.Anuncio;
import br.com.bortolo.repository.AnuncioRepository;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;

	public void save(Anuncio anuncio) throws ParseException {

		anuncioRepository.save(anuncio);

	}

	public List<Anuncio> findAll() throws Exception {

		List<Anuncio> anuncios = anuncioRepository.findAllByOrderByDataCadastroDesc();
		return anuncios.stream().filter(anuncio -> anuncio.getIsActive() == 1).collect(Collectors.toList());

	}

	public List<Anuncio> findByUserId(Integer userId) {
		return anuncioRepository.findByUserIdOrderByIdDesc(userId);
	}

	public void delete(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}

}
