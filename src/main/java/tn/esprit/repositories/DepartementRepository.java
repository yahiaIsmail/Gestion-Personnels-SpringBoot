package tn.esprit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Personnel;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
	
	Page<Departement> findAll(Pageable pageable);

}
