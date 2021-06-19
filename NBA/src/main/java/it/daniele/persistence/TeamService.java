package it.daniele.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.daniele.business.Giocatore;
import it.daniele.business.Team;
import it.daniele.business.repository.GiocatoreRepository;
import it.daniele.business.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository tr;
	@Autowired
	private GiocatoreRepository gr;

	public Team crea(Team con) {
		return tr.save(con);
	}

	public Team update(Team up) {
		if (up.getTeamName() != null) {
			return tr.save(up);
		} else {
			return null;
		}
	}

	public String delete(String nome) {
		Team sq = tr.findByteamName(nome);
		if (sq != null) {
			tr.delete(sq);
			return "eliminato con successo";
		} else {
			return null;
		}
	}

	public Team trova(String nome) {
		return tr.findByteamName(nome);
	}

	public List<Team> trovaTutti() {
		return tr.findAll();
	}

	public List<Team> abbreviazioneTeam(String nome) {
		List<Team> list = tr.findByteamAbbreviation(nome);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	public List<Team> trovaDaConference(String nome) {
		List<Team> team = tr.trovaPerConference(nome);
		if (team.isEmpty()) {
			return null;
		} else {
			return team;
		}
	}

	public String partita(String s1, String s2) {
		int punteggioCasa = 0;
		int punteggioTrasferta = 0;
		List<Giocatore> sq1 = gr.findAllByteamTeamAbbreviation(s1);
		List<Giocatore> sq2 = gr.findAllByteamTeamAbbreviation(s2);
		for (Giocatore giocatore : sq1) {
			for (Giocatore giocatore2 : sq2) {
				double puntiG1 = Double.parseDouble(giocatore.getPercentualePunti());
				double puntiG2 = Double.parseDouble(giocatore2.getPercentualePunti());
				if (puntiG1 >= puntiG2) {
					punteggioCasa += 2;
				} else if (puntiG2 >= puntiG1) {
					punteggioTrasferta += 2;
				}
			}
		}
		if (punteggioCasa > punteggioTrasferta) {
			return "il vincitore e' " +s1 + " con " + punteggioCasa + " punti";
		} else {
			return "il vincitore e' " +s2 + " con " + punteggioTrasferta + " punti";
		}
	}

}
