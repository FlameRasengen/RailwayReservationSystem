package com.railway.railway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.railway.entities.TrainInfo;
import com.railway.railway.entities.UsersInfo;

public interface TrainDao extends JpaRepository<TrainInfo, Integer> {

	
}
