package tn.esprit.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Personnel;
import tn.esprit.repositories.DepartementRepository;
import tn.esprit.repositories.PersonnelRepository;

@Service
public class PersonnelService {

	@Autowired
	PersonnelRepository personnelRepository;

	@Autowired
	DepartementRepository departementRepository;

	public Personnel ajouterPersonnel(Personnel personnel) {
		return personnelRepository.save(personnel);
	}

	public Page<Personnel> getAllPersonnel(Pageable pageable) {
		return personnelRepository.findAll(pageable);
	}

	public List<Personnel> getAllPersonnelByDepartement(int idDepartement) {

		return departementRepository.findById(idDepartement).get().getPersonnels();
	}

	public Optional<Personnel> getPersonnelById(int idPersonnel) {
		return personnelRepository.findById(idPersonnel);
	}

	public void deletePersonnel(int idPersonnel) {
		personnelRepository.deleteById(idPersonnel);
	}

	public Personnel affecterPersonnelDepartement(int idPersonnel, int idDepartement) {

		Personnel personnel = personnelRepository.findById(idPersonnel).get();

		Departement departement = departementRepository.findById(idDepartement).get();
		personnel.setDepartement_personnels(departement);
		return personnelRepository.save(personnel);
	}
}
