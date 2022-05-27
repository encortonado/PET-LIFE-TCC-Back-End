package br.com.bortolo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bortolo.domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	List<Comentario> findByUserIdOrderByDataCadastroDesc(Integer userId);

}
