package tn.esprit.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Departement;
import tn.esprit.services.DepartementService;

@RestController
@RequestMapping("departement")
public class DepartementController {

	@Autowired
	DepartementService departementService;

	@GetMapping
	public ResponseEntity<Page<Departement>> getAllDepartement(Pageable pageable) {

		return new ResponseEntity<Page<Departement>>(departementService.getAllDepartments(pageable), HttpStatus.OK);
	}

	@GetMapping("{idDepartement}")
	public ResponseEntity<Optional<Departement>> getDepartementById(@PathVariable int idDepartement) {

		return new ResponseEntity<Optional<Departement>>(departementService.getDepartementById(idDepartement),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Departement> ajoutDepartement(@RequestBody Departement departement) {

		return new ResponseEntity<Departement>(departementService.ajouterDepartement(departement), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteDepartement(@PathVariable int id) {

		departementService.deleteDepartement(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

}
