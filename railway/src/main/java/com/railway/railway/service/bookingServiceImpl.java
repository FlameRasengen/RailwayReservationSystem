package com.railway.railway.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.railway.railway.config.JwtAuthenticationFilter;
import com.railway.railway.dao.BookingDao;
import com.railway.railway.dao.TrainDao;
import com.railway.railway.entities.BookinDetails;
import com.railway.railway.entities.TrainInfo;
import com.railway.railway.entities.UsersInfo;

@Service
public class bookingServiceImpl implements bookingservice{

	@Autowired
	private TrainDao traindao;
	@Autowired
	private BookingDao bookindao;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	@Autowired
	private UserService userservice;
	@Autowired
	private Optional<TrainInfo> t1;
	
	private final ReentrantLock lock= new ReentrantLock();
	@Override
	public Optional<TrainInfo> findtrain(Integer id) {
		// TODO Auto-generated method stub
		return this.traindao.findById(id);
		
	}
	@Override
	public void bookticket(BookinDetails book) {
		// TODO Auto-generated method stub
		this.bookindao.save(book);
	}
	@Override
	public Optional<BookinDetails> findticket(Integer id) {
		// TODO Auto-generated method stub
		return this.bookindao.findById(id);
	}
	@Override
	public Integer booktickes(Integer id) {
		// TODO Auto-generated method stub
		lock.lock();
		try
		{
			BookinDetails ticketdetails= new BookinDetails();
		
		ticketdetails.setTrain_id(id);
		String username=filter.doFilterInternal1();
		UsersInfo user1= this.userservice.finduser(username); 
		ticketdetails.setUser_id(user1.getUser_id());
		t1= traindao.findById(id);
	    if(t1.get().getAvailableseats()>0)
	    {
	    	this.bookticket(ticketdetails);
	    	t1.get().setAvailableseats(t1.get().getAvailableseats()-1);
	    	this.userservice.addTrain(t1.get());
	    	return ticketdetails.getBooking_id();
	    }
	    else
	    {
	    	return 0;	
	    }
		}
		finally {
			lock.unlock();
		}
	
	}

}
