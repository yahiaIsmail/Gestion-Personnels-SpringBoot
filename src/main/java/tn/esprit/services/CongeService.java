package tn.esprit.services;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Conge;
import tn.esprit.repositories.CongeRepository;
import tn.esprit.repositories.PersonnelRepository;

@Service
public class CongeService {

	@Autowired
	CongeRepository congeRepository;

	@Autowired
	PersonnelRepository personnelRepository;

	public Conge affecterCongeToPersonnel(Conge conge) {
		// conge.setPersonnel(personnelRepository.findById(idPersonnel).get());

		return congeRepository.save(conge);
	}

	public List<Conge> getAllComingConge() {
		ChronoLocalDate dt = LocalDate.from(ZonedDateTime.now());
		return congeRepository.findAll().stream().filter(e -> e.getDateDebut().isAfter(dt))
				.collect(Collectors.toList());
	}
	
	
	public List<Conge> getAllCurrentConge() {
		ChronoLocalDate dt = LocalDate.from(ZonedDateTime.now());
		return congeRepository.findAll().stream().filter(e -> e.getDateFin().isAfter(dt)).filter(x->x.getDateDebut().isBefore(dt))
				.collect(Collectors.toList());
	}
}
