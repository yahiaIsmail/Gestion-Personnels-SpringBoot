package tn.esprit.resources;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Personnel;
import tn.esprit.services.PersonnelService;

@RestController
@RequestMapping("personnel")
public class PersonnelController {

	@Autowired
	PersonnelService personnelService;

	@GetMapping
	public ResponseEntity<Page<Personnel>> getAllPersonnel(Pageable pageable) {

		/*
		 * Personnel p = new Personnel(); p.setDateNaissance(LocalDate.of(2017, 11, 6));
		 * personnelService.ajouterPersonnel(p);
		 */

		return new ResponseEntity<Page<Personnel>>(personnelService.getAllPersonnel(pageable), HttpStatus.OK);
	}

	@GetMapping("{idPersonnel}")
	public ResponseEntity<Optional<Personnel>> getPersonnelById(@PathVariable int idPersonnel) {

		return new ResponseEntity<Optional<Personnel>>(personnelService.getPersonnelById(idPersonnel), HttpStatus.OK);
	}

	@GetMapping("departement")
	public ResponseEntity<List<Personnel>> getAllPersonnelByDepartement(
			@RequestParam(value = "idDepartement") int idDepartement) {

		return new ResponseEntity<List<Personnel>>(personnelService.getAllPersonnelByDepartement(idDepartement),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Personnel> ajouterPersonnel(@RequestBody Personnel personnel) {

		return new ResponseEntity<Personnel>(personnelService.ajouterPersonnel(personnel), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletePersonnel(@PathVariable int id) {

		personnelService.deletePersonnel(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

	@PutMapping
	public ResponseEntity<Personnel> affecterPersonnelDepartement(
			@RequestParam(value = "idPersonnel", required = true) int idPersonnel,
			@RequestParam(value = "idDepartement", required = true) int idDepartement

	) {

		return new ResponseEntity<Personnel>(personnelService.affecterPersonnelDepartement(idPersonnel, idDepartement),
				HttpStatus.ACCEPTED);

	}

}
