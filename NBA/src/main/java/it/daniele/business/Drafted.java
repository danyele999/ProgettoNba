package it.daniele.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Drafted {
	
	@Id
	private int rank;
	@ManyToOne
	private Team teamDraftedBy;
	private String player;
	private String college;
	

}
