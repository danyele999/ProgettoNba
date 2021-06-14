package it.daniele.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.daniele.business.Team;
import it.daniele.business.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository tr;

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

}
