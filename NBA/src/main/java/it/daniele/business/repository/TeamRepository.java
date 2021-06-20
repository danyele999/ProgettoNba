package it.daniele.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.daniele.business.Team;

public interface TeamRepository extends JpaRepository<Team, String> {

	Team findByteamName(String nome);

	List<Team> findAll();

	Team findByteamAbbreviation(String nome);

	@Query("SELECT t FROM Team t WHERE t.conference.conferenceName LIKE %:nome%")
	List<Team> trovaPerConference(String nome);
	
	

}
