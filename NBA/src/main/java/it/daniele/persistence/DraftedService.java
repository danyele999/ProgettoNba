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

import it.daniele.business.Drafted;
import it.daniele.business.Team;
import it.daniele.business.repository.DraftedRepository;
import it.daniele.business.repository.TeamRepository;

@Service
public class DraftedService {

	@Autowired
	private DraftedRepository dr;

	@Autowired
	private TeamRepository tr;

	public Drafted crea(Drafted con) {
		return dr.save(con);
	}

	public Drafted update(Drafted up) {
		if (up != null) {
			return dr.save(up);
		} else {
			return null;
		}
	}

	public String delete(Long id) {
		if (id != null) {
			Drafted draf = dr.findByrank(id);
			dr.delete(draf);
			return "eliminato con successo";
		} else {
			return null;
		}
	}

	public Drafted ricercaDaRank(Long rank) {
		Drafted de = dr.findByrank(rank);
		if (de != null) {
			return de;
		} else {
			return null;
		}
	}

	public void readDraft() {
		List<Team> provi = tr.findAll();
		String inputFile = "C:/Users/Daniele/Desktop/classeDraft2020.csv";
		try (Reader reader = Files.newBufferedReader(Paths.get(inputFile))) {
			try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';').withTrim())) {
				for (CSVRecord p : csvParser) {
					for (Team o : provi) {
						if (p.get(1).equals(o.getTeamAbbreviation())) {
							Drafted c1 = new Drafted();
							c1.setRank(Long.parseLong(p.get(0)));
							c1.setTeamDraftedBy(o);
							c1.setPlayer(p.get(2));
							dr.save(c1);

						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
