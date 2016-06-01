package com.itekkies.training.events;

public class Events {
	private int id;
	private String eventName;
	private int eventDate;   //Just contains date.
	private int eventMonth;
	private int eventYear;
	private Person person;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public int getEventDate() {
		return eventDate;
	}
	public void setEventDate(int eventDate) {
		this.eventDate = eventDate;
	}
	
	public int getEventMonth() {
		return eventMonth;
	}
	public void setEventMonth(int eventMonth) {
		this.eventMonth = eventMonth;
	}
	
	public int getEventYear() {
		return eventYear;
	}
	public void setEventYear(int eventYear) {
		this.eventYear = eventYear;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
