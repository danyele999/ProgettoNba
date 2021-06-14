package it.daniele.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.daniele.business.Conference;
import it.daniele.business.repository.conferenceRepository;

@Service
public class ConferenceService {

	@Autowired
	private conferenceRepository confrepo;

	public Conference crea(Conference con) {
		return confrepo.save(con);
	}

	public Conference update(Conference up) {
		if (up.getId() != null) {
			return confrepo.save(up);
		} else {
			return null;
		}
	}

	public String delete(Long id) {
		if (id != null) {
			confrepo.deleteById(id);
			return "eliminato con successo";
		} else {
			return null;
		}
	}

}
