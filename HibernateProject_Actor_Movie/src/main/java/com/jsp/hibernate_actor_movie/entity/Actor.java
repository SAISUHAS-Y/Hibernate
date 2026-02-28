package com.jsp.hibernate_actor_movie.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	private int actorId;
	private String actorName;
	private int actorAge;
	private int actorSalary;
	private String actorIndustry;
	private String actorNation;

	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getActorAge() {
		return actorAge;
	}

	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}

	public int getActorSalary() {
		return actorSalary;
	}

	public void setActorSalary(int actorSalary) {
		this.actorSalary = actorSalary;
	}

	public String getActorIndustry() {
		return actorIndustry;
	}

	public void setActorIndustry(String actorIndustry) {
		this.actorIndustry = actorIndustry;
	}

	public String getActorNation() {
		return actorNation;
	}

	public void setActorNation(String actorNation) {
		this.actorNation = actorNation;
	}

	

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAge=" + actorAge + ", actorSalary="
				+ actorSalary + ", actorIndustry=" + actorIndustry + ", actorNation=" + actorNation + ", movies="
				+ movies + "]";
	}
	

	
}
