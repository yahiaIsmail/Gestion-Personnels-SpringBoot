package tn.esprit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Departement;
import tn.esprit.repositories.DepartementRepository;

@Service
public class DepartementService {

	@Autowired
	DepartementRepository departementRepository;

	public Departement ajouterDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	public Page<Departement> getAllDepartments(Pageable pageable) {
		return departementRepository.findAll(pageable);
	}

	public Optional<Departement> getDepartementById(int idDepartement) {
		return departementRepository.findById(idDepartement);
	}

	public void deleteDepartement(int idDepartement) {
		departementRepository.deleteById(idDepartement);
	}
}
