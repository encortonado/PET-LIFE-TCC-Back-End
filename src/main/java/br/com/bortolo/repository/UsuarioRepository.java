package br.com.bortolo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bortolo.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findFirstByEmailAndPassword(String usuario, String password);

	Usuario findFirstByEmail(String email);

	Usuario findFirstById(Integer userId);

	@Query(value="SELECT DISTINCT cidade FROM usuario", nativeQuery = true)
	List<String> findAllCities();

}
