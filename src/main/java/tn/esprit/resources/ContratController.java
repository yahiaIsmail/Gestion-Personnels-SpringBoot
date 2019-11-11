package tn.esprit.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Contrat;
import tn.esprit.services.ContratService;

@RestController
@RequestMapping("contrat")
public class ContratController {

	@Autowired
	ContratService contratService;

	@PostMapping
	public ResponseEntity<Contrat> ajouterConge(@RequestBody Contrat contrat) {

		return new ResponseEntity<Contrat>(contratService.ajouterContrat(contrat) ,HttpStatus.OK);
	}
	

}
