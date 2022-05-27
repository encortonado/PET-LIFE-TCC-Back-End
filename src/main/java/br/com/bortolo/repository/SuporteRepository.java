package br.com.bortolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bortolo.domain.Suporte;

@Repository
public interface SuporteRepository extends JpaRepository<Suporte, Integer> {

}
