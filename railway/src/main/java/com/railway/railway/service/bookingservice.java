package com.railway.railway.service;

import java.util.Optional;

import com.railway.railway.entities.BookinDetails;
import com.railway.railway.entities.TrainInfo;

public interface bookingservice {
	public Optional<TrainInfo>  findtrain(Integer id);
	public void bookticket(BookinDetails book);
	public Optional<BookinDetails> findticket(Integer id);
	public Integer booktickes(Integer id);

}
