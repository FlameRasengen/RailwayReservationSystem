package com.railway.railway.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAININFO")
public class TrainInfo {
	
	@Id
	private Integer train_id;
	private String Source;
	private String destination;
	private Integer Totalseats;
	private Integer availableseats;
	public Integer getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Integer train_id) {
		this.train_id = train_id;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getTotalseats() {
		return Totalseats;
	}
	public void setTotalseats(Integer totalseats) {
		this.Totalseats = totalseats;
	}
	public Integer getAvailableseats() {
		return availableseats;
	}
	public void setAvailableseats(Integer availableseats) {
		this.availableseats = availableseats;
	}
	@Override
	public String toString() {
		return "TrainInfo [train_id=" + train_id + ", Source=" + Source + ", destination=" + destination
				+ ", Totalseats=" + Totalseats + ", availableseats=" + availableseats + "]";
	}
	public TrainInfo(Integer train_id, String source, String destination, Integer totalseats, Integer availableseats) {
		super();
		this.train_id = train_id;
		Source = source;
		this.destination = destination;
		Totalseats = totalseats;
		this.availableseats = availableseats;
	}
	public TrainInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
