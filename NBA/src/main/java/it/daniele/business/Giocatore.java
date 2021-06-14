package it.daniele.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Giocatore {
	@Id
	private String nomeGiocatore;
	private String posizione;
	private String eta;
	private String abbreviazioneTeam;
	private String partiteGiocate;
	private String percentualeDa3;
	private String percentualeDa2;
	private String percentualeTiroLibero;
	private String assist;
	private String palleRubate;
	private String Stoppate;
	private String pf;
	private String percentualePunti;
	@ManyToOne
	private Team team;

}
