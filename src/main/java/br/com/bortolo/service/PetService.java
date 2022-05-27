package br.com.bortolo.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bortolo.domain.Pet;
import br.com.bortolo.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	public void save(Pet pet) throws ParseException {

		petRepository.save(pet);

	}

	public List<Pet> findAll() throws ParseException {

		return petRepository.findAll();

	}

	public List<Pet> findByUserId(Integer userId) {
		return petRepository.findByUserId(userId);
	}
	
	public Pet findPetById(Integer petId) {
		return petRepository.findPetById(petId);
	}

	public void delete(Pet pet) {
		petRepository.delete(pet);
	}

}
