package br.com.bortolo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bortolo.domain.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

	List<Agenda> findByClienteIdOrderByData(Integer clienteId);

	List<Agenda> findByAnuncianteIdOrderByData(Integer clienteId);
	
	Agenda findById(Integer id);
	

}
