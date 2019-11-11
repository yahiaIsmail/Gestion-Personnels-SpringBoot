package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Contrat;
import tn.esprit.repositories.ContratRepository;
import tn.esprit.repositories.PersonnelRepository;

@Service
public class ContratService {

	@Autowired
	ContratRepository contratRepository;

	@Autowired
	PersonnelRepository personnelRepository;

	public Contrat ajouterContrat(Contrat contrat) {

		return contratRepository.save(contrat);
	}
	
	

}
