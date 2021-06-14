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

import it.daniele.business.Giocatore;
import it.daniele.persistence.GiocatoreService;

@RestController
@RequestMapping("/giocatore")
public class GiocatoreController {

	@Autowired
	private GiocatoreService gs;

	@GetMapping("/import")
	public String inport() {
		gs.readomune();
		return "ok";
	}

	@GetMapping("/inserimento")
	public ResponseEntity<Giocatore> inserimento(@RequestBody Giocatore giocatore) {
		Giocatore g1 = gs.crea(giocatore);
		if (g1 == null) {
			return new ResponseEntity<Giocatore>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Giocatore>(g1, HttpStatus.ACCEPTED);
		}
	}

	@PutMapping("/aggiorna")
	public ResponseEntity<Giocatore> aggiornaGiocatore(@RequestBody Giocatore giocatore) {
		Giocatore g1 = gs.crea(giocatore);
		if (g1 == null) {
			return new ResponseEntity<Giocatore>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Giocatore>(g1, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping("/elimina/{nome}")
	public ResponseEntity<String> eliminaGiocatore(@PathVariable String nome) {
		if (nome == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>(gs.delete(nome), HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/listaGiocatori")
	public ResponseEntity<List<Giocatore>> listaCompleta() {
		List<Giocatore> lista = gs.listaGiocatori();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/trovaSquadra/{nome}")
	public ResponseEntity<List<Giocatore>> trovaGiocatoreDaTeam(@PathVariable String nome) {
		List<Giocatore> lista = gs.trovaDaTeam(nome);
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}

	}

	@GetMapping("/PerPunti")
	public ResponseEntity<?> ordinaPerPunti() {
		List<Giocatore> lista = gs.ordinaPerPunti();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/Da3")
	public ResponseEntity<?> percentualeDa3() {
		List<Giocatore> lista = gs.ordinaPerPunti();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/Da2")
	public ResponseEntity<?> percentualeDa2() {
		List<Giocatore> lista = gs.ordinaPerPunti();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/assist")
	public ResponseEntity<?> assist() {
		List<Giocatore> lista = gs.assist();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/palleRubate")
	public ResponseEntity<?> palleRubate() {
		List<Giocatore> lista = gs.palleRubate();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/Stoppate")
	public ResponseEntity<?> Stoppate() {
		List<Giocatore> lista = gs.Stoppate();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/trovaDaPosizione/{nome}")
	public ResponseEntity<List<Giocatore>> trovaGiocatoreDaPosizione(@PathVariable String nome) {
		List<Giocatore> lista = gs.trovaDaPosizione(nome);
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Giocatore>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Giocatore>>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/partiteGiocateRange/{val1}/{val2}")
	public ResponseEntity<?> partiteParametrizzate(@PathVariable int val1, @PathVariable int val2) {
		List<Giocatore> lista = gs.partiteGiocateParam(val1, val2);
		if (lista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(lista, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/puntiGiocatoreRange/{val1}/{val2}")
	public ResponseEntity<?> punteggiParametrizzate(@PathVariable int val1, @PathVariable int val2) {
		List<Giocatore> lista = gs.puntiGiocateParam(val1, val2);
		if (lista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(lista, HttpStatus.ACCEPTED);
		}
	}

}
