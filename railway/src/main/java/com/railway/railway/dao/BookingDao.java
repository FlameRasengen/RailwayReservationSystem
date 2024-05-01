package com.railway.railway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.railway.entities.BookinDetails;
import com.railway.railway.entities.TrainInfo;

public interface BookingDao extends JpaRepository<BookinDetails, Integer> {

}
