package com.jsp.hibernate_query.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {

	@Id
	private int actorId;
	private String actorName;
	private int actorAge;
	private String actorStream;

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAge=" + actorAge + ", actorStream="
				+ actorStream + ", actorNationality=" + actorNationality + "]";
	}

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

	public String getActorStream() {
		return actorStream;
	}

	public void setActorStream(String actorStream) {
		this.actorStream = actorStream;
	}

	public String getActorNationality() {
		return actorNationality;
	}

	public void setActorNationality(String actorNationality) {
		this.actorNationality = actorNationality;
	}

	private String actorNationality;

}
