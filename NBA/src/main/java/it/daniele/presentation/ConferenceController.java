package it.daniele.presentation;

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

import it.daniele.business.Conference;
import it.daniele.persistence.ConferenceService;

@RestController
@RequestMapping("/nba")
public class ConferenceController {

	@Autowired
	private ConferenceService cs;

	@GetMapping("/conference")
	public ResponseEntity<Conference> crea(@RequestBody Conference crea) {
		Conference creato = cs.crea(crea);
		if (creato != null) {
			return new ResponseEntity<>(creato, HttpStatus.OK);
		} else {
			return new ResponseEntity<Conference>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/aggiorna")
	public ResponseEntity<Conference> aggiorna(@RequestBody Conference con) {
		Conference creato = cs.update(con);
		if (creato != null) {
			return new ResponseEntity<>(creato, HttpStatus.OK);
		} else {
			return new ResponseEntity<Conference>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/cancella/{id}")
	public ResponseEntity<String> cancella(@PathVariable Long id) {
		cs.delete(id);
		return new ResponseEntity<String>("cancellazione avvenuta con successo da parte di Daniele",HttpStatus.OK);
	}

}
