package it.daniele.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.daniele.business.Drafted;

public interface DraftedRepository extends JpaRepository<Drafted, Integer> {

	Drafted findByrank(Long rank);
	
	List<Drafted> findAll();

}
