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

import it.daniele.business.Drafted;
import it.daniele.persistence.DraftedService;

@RestController
@RequestMapping("/drafted")
public class DraftedController {

	@Autowired
	private DraftedService ds;

	@GetMapping("/insert")
	public ResponseEntity<Drafted> crea(@RequestBody Drafted crea) {
		Drafted creato = ds.crea(crea);
		if (creato != null) {
			return new ResponseEntity<>(creato, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/aggiorna")
	public ResponseEntity<Drafted> aggiorna(@RequestBody Drafted con) {
		Drafted creato = ds.update(con);
		if (creato != null) {
			return new ResponseEntity<>(creato, HttpStatus.OK);
		} else {
			return new ResponseEntity<Drafted>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/cancella/{id}")
	public ResponseEntity<String> cancella(@PathVariable Long id) {
		ds.delete(id);
		return new ResponseEntity<String>("cancellazione avvenuta con successo da parte di Daniele", HttpStatus.OK);
	}

	@GetMapping("/ricerca/{id}")
	public ResponseEntity<Drafted> ricerca(@PathVariable Long id) {
		Drafted d1 = ds.ricercaDaRank(id);
		if (d1 != null) {
			return new ResponseEntity<Drafted>(d1, HttpStatus.OK);
		} else {
			return new ResponseEntity<Drafted>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/upload")
	public ResponseEntity<List<Drafted>> upload() {
		ds.readDraft();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
