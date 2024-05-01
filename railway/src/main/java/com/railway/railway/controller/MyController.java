package com.railway.railway.controller;

import java.util.List;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.tomcat.jni.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.railway.railway.config.JwtAuthenticationFilter;
import com.railway.railway.dao.TrainDao;
import com.railway.railway.enities.Trainrequest;
import com.railway.railway.entities.BookinDetails;
import com.railway.railway.entities.JwtRequest;
import com.railway.railway.entities.TrainInfo;
import com.railway.railway.entities.UsersInfo;
import com.railway.railway.service.UserService;
import com.railway.railway.service.bookingservice;

@RestController
public class MyController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private TrainDao traindetails;

	@Autowired
	private bookingservice servicebooking;
	
	@Autowired
	private Optional<TrainInfo> t1;
	
	private final ReentrantLock lock= new ReentrantLock();
	
	@Autowired
	private JwtAuthenticationFilter filter;
	@PostMapping("/api/sign-up")
	public ResponseEntity<Object> UserSignUp(@RequestBody JwtRequest request)
	{
		UsersInfo user= new UsersInfo();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		if(userservice.finduser(user))
			{
			 return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "status", "User already prersent. Please retry",
		            "status_code", HttpStatus.UNAUTHORIZED));
			}
		else {
		this.userservice.addUser(user);
		 return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "status", "User Account Successfully Created",
		            "status_code", HttpStatus.OK,
		            "User_id",user.getUser_id()));
		}
		
		
	} 
	@PostMapping("/api/train")
	public String addTrain(@RequestBody TrainInfo train)
	{
		
		this.userservice.addTrain(train);
		return "train added successfully";
		
	}
	@GetMapping("/api/trains")
	public List<TrainInfo> availabletrains(@RequestBody Trainrequest trainrequest)
	{
		Trainrequest train= trainrequest;
		System.out.println(train.getSource());
		System.out.println(train.getDestination());
		return this.userservice.availableTrain(trainrequest.getSource(),trainrequest.getDestination() );
	}
	@PostMapping("/api/train/{id}")
	public ResponseEntity<Object> bookticket(@PathVariable("id") Integer id)
	{

		try {
			Integer response=this.servicebooking.booktickes(id);
		if(response != null)
		{return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "status", "Ticket booked Successfully",
	            "booking_id",response,
	            "status_code", HttpStatus.CREATED));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "status", "Seats are Fulled. Please retry",
		            "status_code", HttpStatus.UNAUTHORIZED));
		}
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	@GetMapping("/api/booking/{id}")
	public ResponseEntity<Object> showdetails(@PathVariable("id") Integer id)
	{
		Optional<BookinDetails> ticket= this.servicebooking.findticket(id); 
		Optional<TrainInfo> train= this.servicebooking.findtrain(ticket.get().getTrain_id());
		
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "train_id",ticket.get().getTrain_id(),
	            "Destination", train.get().getSource(),
	            "Source", train.get().getDestination()));
		
	}
	
	

}
