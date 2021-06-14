package it.daniele.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.daniele.business.Conference;

public interface conferenceRepository extends JpaRepository<Conference, Long> {

	Conference findByconferenceName(String nome);

}
