package com.railway.railway.enities;

public class Trainrequest {
	private String Source;
	private String Destination;
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		this.Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		this.Destination = destination;
	}
	@Override
	public String toString() {
		return "Trainrequest [Source=" + Source + ", Destination=" + Destination + "]";
	}
	public Trainrequest(String source, String destination) {
		super();
		Source = source;
		Destination = destination;
	}
	public Trainrequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
