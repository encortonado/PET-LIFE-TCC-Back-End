package br.com.bortolo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bortolo.domain.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

	List<Pet> findAll();

	List<Pet> findById(Integer id);

	List<Pet> findByUserId(Integer id);

	Pet findPetById(Integer petId);

}
