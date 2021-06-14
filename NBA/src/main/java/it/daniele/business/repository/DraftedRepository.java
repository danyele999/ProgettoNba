package it.daniele.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.daniele.business.Drafted;

public interface DraftedRepository extends JpaRepository<Drafted, Integer> {

}
