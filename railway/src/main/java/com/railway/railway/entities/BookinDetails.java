package com.railway.railway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGDETAILS")
public class BookinDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer booking_id;
	private Integer user_id;
	private Integer train_id;
	public Integer getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Integer train_id) {
		this.train_id = train_id;
	}
	@Override
	public String toString() {
		return "BookinDetails [booking_id=" + booking_id + ", user_id=" + user_id + ", train_id=" + train_id + "]";
	}
	public BookinDetails(Integer booking_id, Integer user_id, Integer train_id) {
		super();
		this.booking_id = booking_id;
		this.user_id = user_id;
		this.train_id = train_id;
	}
	public BookinDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
