package it.daniele.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.daniele.business.Team;
import it.daniele.persistence.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService ts;

	@GetMapping("/conference")
	public ResponseEntity<Team> crea(@RequestBody Team crea) {
		Team creato = ts.crea(crea);
		if (creato != null) {
			return new ResponseEntity<>(creato, HttpStatus.OK);
		} else {
			return new ResponseEntity<Team>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/aggiorna")
	public ResponseEntity<Team> aggiorna(@RequestBody Team con) {
		Team creato = ts.update(con);
		if (creato != null) {
			return new ResponseEntity<>(creato, HttpStatus.OK);
		} else {
			return new ResponseEntity<Team>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/cancella/{nome}")
	public ResponseEntity<String> cancella(@PathVariable String nome) {
		ts.delete(nome);
		return new ResponseEntity<String>("cancellazione avvenuta con successo da parte di Daniele", HttpStatus.OK);
	}

	@GetMapping("/trova/{nome}")
	public ResponseEntity<Team> trova(@PathVariable String nome) {
		Team trovato = ts.trova(nome);
		if (trovato == null) {
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Team>(trovato, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/trova")
	public ResponseEntity<List<Team>> trovaTutti() {
		return new ResponseEntity<>(ts.trovaTutti(), HttpStatus.OK);
	}

	@GetMapping("/abbreviazione/{nome}")
	public ResponseEntity<Team> abbreviazione(@PathVariable String nome) {
		Team lista = ts.abbreviazioneTeam(nome);
		if (lista == null) {
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Team>(lista, HttpStatus.ACCEPTED);
		}

	}

	@GetMapping("/conferenceName/{nome}")
	public ResponseEntity<List<Team>> conferenceN(@PathVariable String nome) {
		List<Team> te = ts.trovaDaConference(nome);
		if (te.isEmpty()) {
			return new ResponseEntity<List<Team>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Team>>(te, HttpStatus.OK);
		}
	}

	@GetMapping("/partita/{s1}/{s2}")
	public ResponseEntity<String> partita(@PathVariable String s1, @PathVariable String s2) {
		return new ResponseEntity<>(ts.partita(s1, s2), HttpStatus.OK);

	}

}
