package it.daniele.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.daniele.business.Giocatore;

public interface GiocatoreRepository extends JpaRepository<Giocatore, String> {

	Giocatore findBynomeGiocatore(String nome);

	List<Giocatore> findAll();

	List<Giocatore> findByteamTeamAbbreviation(String abbreviazione);

}
