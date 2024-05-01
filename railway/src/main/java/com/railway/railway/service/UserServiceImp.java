package com.railway.railway.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.railway.railway.dao.BookingDao;
import com.railway.railway.dao.TrainDao;
import com.railway.railway.dao.UserInfo;
import com.railway.railway.entities.BookinDetails;
import com.railway.railway.entities.TrainInfo;
import com.railway.railway.entities.UsersInfo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserInfo userInfo;
	
	@Autowired
	private TrainDao traindao;
	
	
	@Override
	public void addUser(UsersInfo user) {
		// TODO Auto-generated method stub
		this.userInfo.save(user);

	}
	@Override
	public void addTrain(TrainInfo train) {
		// TODO Auto-generated method stub
		this.traindao.save(train);
	}
	
	
	@Override
	public List<TrainInfo> availableTrain(String staring, String ending) {
		// TODO Auto-generated method stub
		List<TrainInfo> totaltrain= this.traindao.findAll();
		List<TrainInfo>availabletrains= new ArrayList<TrainInfo>();
		System.out.println(staring);
		System.out.println(ending);
		totaltrain.forEach((p)->
		{
			if(p.getSource().equals(staring)&& p.getDestination().equals(ending))
			{
				System.out.println(p.getSource());
				System.out.println(p.getDestination());
				availabletrains.add(p);
			}
		}
	);
	return availabletrains;	
	}
	@Override
	public boolean finduser(UsersInfo user) {
		// TODO Auto-generated method stub
		if(this.userInfo.findByUsername(user.getUsername()) != null)
			return true;
		else
			return false;
	}
	@Override
	public UsersInfo finduser(String Username) {
		// TODO Auto-generated method stub
		return this.userInfo.findByUsername(Username);
	}
	
	
	
	

}
