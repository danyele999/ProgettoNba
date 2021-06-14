package it.daniele.persistence;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.daniele.business.Giocatore;
import it.daniele.business.Team;
import it.daniele.business.repository.GiocatoreRepository;
import it.daniele.business.repository.TeamRepository;

@Service
public class GiocatoreService {

	@Autowired
	private GiocatoreRepository gr;

	@Autowired
	private TeamRepository tr;

	public Giocatore crea(Giocatore con) {
		return gr.save(con);
	}

	public Giocatore update(Giocatore up) {
		if (up.getNomeGiocatore() != null) {
			return gr.save(up);
		} else {
			return null;
		}
	}

	public String delete(String nome) {
		Giocatore gio = gr.findBynomeGiocatore(nome);
		if (gio != null) {
			gr.delete(gio);
			return "eliminato con successo";
		} else {
			return null;
		}
	}

	public Giocatore trova(String nome) {
		return gr.findBynomeGiocatore(nome);
	}

	public void readomune() {
		List<Team> provi = tr.findAll();
		String inputFile = "C:/Users/Daniele/Desktop/nbaStats.csv";
		try (Reader reader = Files.newBufferedReader(Paths.get(inputFile))) {
			try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';').withTrim())) {
				for (CSVRecord p : csvParser) {
					for (Team o : provi) {
						if (p.get(3).equals(o.getTeamAbbreviation())) {
							Giocatore c1 = new Giocatore();
							c1.setNomeGiocatore(p.get(0));
							c1.setPosizione(p.get(1));
							c1.setEta(p.get(2));
							c1.setAbbreviazioneTeam(p.get(3));
							c1.setPartiteGiocate(p.get(4));
							c1.setPercentualeDa3(p.get(5));
							c1.setPercentualeDa2(p.get(6));
							c1.setPercentualeTiroLibero(p.get(7));
							c1.setAssist(p.get(8));
							c1.setPalleRubate(p.get(9));
							c1.setStoppate(p.get(10));
							c1.setPf(p.get(11));
							c1.setPercentualePunti(p.get(12));
							c1.setTeam(o);
							gr.save(c1);

						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Giocatore> listaGiocatori() {
		List<Giocatore> lista = gr.findAll();
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista;
		}
	}

	public List<Giocatore> trovaDaTeam(String abb) {
		List<Giocatore> risultato = gr.findByteamTeamAbbreviation(abb);
		if (risultato.isEmpty()) {
			return null;
		} else {
			return risultato;
		}
	}

	public List<Giocatore> ordinaPerPunti() {
		List<Giocatore> ordinamento = gr.ordinaPerpercentualePuntiDesc();
		if (ordinamento.isEmpty()) {
			return null;
		} else {
			return ordinamento;
		}
	}

	public List<Giocatore> ordinaPartiteGiocate() {
		List<Giocatore> liste = gr.ordinaPerpartiteGiocateDesc();
		if (liste.isEmpty()) {
			return null;
		} else {
			return liste;
		}
	}

	public List<Giocatore> percentualeDa3() {
		List<Giocatore> liste = gr.ordinaPerpercentualeDa3Desc();
		if (liste.isEmpty()) {
			return null;
		} else {
			return liste;
		}
	}

	public List<Giocatore> percentualeDa2() {
		List<Giocatore> liste = gr.ordinaPerPercentualeDa2Desc();
		if (liste.isEmpty()) {
			return null;
		} else {
			return liste;
		}
	}

	public List<Giocatore> assist() {
		List<Giocatore> liste = gr.ordinaPerassistDesc();
		if (liste.isEmpty()) {
			return null;
		} else {
			return liste;
		}
	}

	public List<Giocatore> palleRubate() {
		List<Giocatore> liste = gr.ordinaPerPalleRubateDesc();
		if (liste.isEmpty()) {
			return null;
		} else {
			return liste;
		}
	}

	public List<Giocatore> Stoppate() {
		List<Giocatore> liste = gr.ordinaPerStoppateDesc();
		if (liste.isEmpty()) {
			return null;
		} else {
			return liste;
		}
	}

	public List<Giocatore> trovaDaPosizione(String nome) {
		List<Giocatore> lista = gr.findByposizione(nome);
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista;
		}
	}

	public List<Giocatore> partiteGiocateParam(int val1, int val2) {
		String valore1 = Integer.toString(val1);
		String valore2 = Integer.toString(val2);
		List<Giocatore> lista = gr.findBypartiteGiocateBetween(valore1, valore2);
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista;
		}

	}

	public List<Giocatore> puntiGiocateParam(int val1, int val2) {
		String valore1 = Integer.toString(val1);
		String valore2 = Integer.toString(val2);
		List<Giocatore> lista = gr.findBypercentualePuntiBetween(valore1, valore2);
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista;
		}

	}

}
