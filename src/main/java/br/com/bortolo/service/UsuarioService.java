package br.com.bortolo.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bortolo.domain.Usuario;
import br.com.bortolo.dto.UsuarioDTO;
import br.com.bortolo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void save(UsuarioDTO usuarioDto) throws ParseException {

		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDto, usuario);
		usuario.setDataNascimento(usuarioDto.getDataNascimento());

		usuarioRepository.save(usuario);

	}

	public Usuario findFirstByEmailAndPassword(String email, String senha) {
		return usuarioRepository.findFirstByEmailAndPassword(email, senha);
	}

	public Usuario findFirstByEmail(String email) {
		return usuarioRepository.findFirstByEmail(email);
	}

	public Usuario findUserById(Integer userId) {
		return usuarioRepository.findFirstById(userId);

	}

	public List<String> getAllCities() {
		return usuarioRepository.findAllCities();
	}
}
