package it.daniele.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.daniele.business.Giocatore;

public interface GiocatoreRepository extends JpaRepository<Giocatore, String> {

	Giocatore findBynomeGiocatore(String nome);

	List<Giocatore> findAll();

	List<Giocatore> findAllByteamTeamAbbreviation(String abbreviazione);

	@Query("SELECT g FROM Giocatore g ORDER BY g.percentualePunti")
	List<Giocatore> ordinaPerpercentualePuntiDesc();

	@Query("SELECT g FROM Giocatore g ORDER BY g.partiteGiocate")
	List<Giocatore> ordinaPerpartiteGiocateDesc();

	@Query("SELECT g FROM Giocatore g ORDER BY g.percentualeDa3")
	List<Giocatore> ordinaPerpercentualeDa3Desc();

	@Query("SELECT g FROM Giocatore g ORDER BY g.percentualeDa2")
	List<Giocatore> ordinaPerPercentualeDa2Desc();

	@Query("SELECT g FROM Giocatore g ORDER BY g.assist")
	List<Giocatore> ordinaPerassistDesc();

	@Query("SELECT g FROM Giocatore g ORDER BY g.palleRubate")
	List<Giocatore> ordinaPerPalleRubateDesc();

	@Query("SELECT g FROM Giocatore g ORDER BY g.Stoppate")
	List<Giocatore> ordinaPerStoppateDesc();
	
	List<Giocatore> findByposizione(String posizione);
	
	List<Giocatore> findBypartiteGiocateBetween(String par1, String par2);
	
	List<Giocatore> findBypercentualePuntiBetween(String par1, String par2);
	
	

}
