package tn.esprit.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Conge;
import tn.esprit.services.CongeService;

@RestController
@RequestMapping("conge")
public class CongeController {

	@Autowired
	CongeService congeService;

	@PostMapping
	public ResponseEntity<Conge> ajouterConge(@RequestBody Conge conge) {

		return new ResponseEntity<Conge>(congeService.affecterCongeToPersonnel(conge), HttpStatus.OK);
	}
	
	@GetMapping("coming")
	public ResponseEntity<List<Conge>> getAllComingConge() {

		return new ResponseEntity<List<Conge>>(congeService.getAllComingConge(), HttpStatus.OK);
	}
	
	@GetMapping("current")
	public ResponseEntity<List<Conge>> getAllcurrent() {

		return new ResponseEntity<List<Conge>>(congeService.getAllCurrentConge(), HttpStatus.OK);
	}
}
