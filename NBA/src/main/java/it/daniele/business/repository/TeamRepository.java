package it.daniele.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.daniele.business.Team;

public interface TeamRepository extends JpaRepository<Team, String> {

	Team findByteamName(String nome);
	List<Team> findAll();
	

}
