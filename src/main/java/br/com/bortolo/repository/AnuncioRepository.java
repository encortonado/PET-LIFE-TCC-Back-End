package br.com.bortolo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bortolo.domain.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

	List<Anuncio> findAllByOrderByDataCadastroDesc();

	List<Anuncio> findByUserIdOrderByIdDesc(Integer userId);

	@Query(value = "select a.* from anuncio a inner join usuario u on a.user_id = u.id where u.cidade = :cidade and a.titulo = :servico order by id desc", nativeQuery = true)
	List<Anuncio> findAnuncioByCityAndService(@Param("cidade") String cidade, @Param("servico") String servico);

	@Query(value = "select a.* from anuncio a inner join usuario u on a.user_id = u.id where u.cidade = :cidade order by id desc", nativeQuery = true)
	List<Anuncio> findAnuncioByCity(@Param("cidade") String cidade);

	@Query(value = "select * from anuncio where titulo = :servico order by id desc", nativeQuery = true)
	List<Anuncio> findAnuncioByService(@Param("servico") String servico);

}
