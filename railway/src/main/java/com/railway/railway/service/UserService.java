package com.railway.railway.service;

import java.util.List;

import com.railway.railway.entities.BookinDetails;
import com.railway.railway.entities.TrainInfo;
import com.railway.railway.entities.UsersInfo;

public interface UserService {
	public void addUser(UsersInfo user);
	public UsersInfo finduser(String Username);
	public boolean finduser(UsersInfo user);
	public void addTrain(TrainInfo train);
	public List<TrainInfo> availableTrain(String staring,String ending);
	
	
}
