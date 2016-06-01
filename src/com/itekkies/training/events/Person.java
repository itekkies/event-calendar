package com.itekkies.training.events;

import java.util.List;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private List<Events> events;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lname){
		this.lastName = lname;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}
}
