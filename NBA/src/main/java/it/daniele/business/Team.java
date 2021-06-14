package it.daniele.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	private String teamName;
	private String teamAbbreviation;
	@JsonIgnore
	@OneToMany(mappedBy = "team")
	private List<Giocatore> giocatore;
	@ManyToOne
	private Conference conference;
	@JsonIgnore
	@OneToMany(mappedBy = "teamDraftedBy")
	private List<Drafted> draft;

}
