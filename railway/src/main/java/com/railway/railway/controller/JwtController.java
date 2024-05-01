package com.railway.railway.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.railway.railway.dao.UserInfo;
import com.railway.railway.entities.JwtRequest;
import com.railway.railway.entities.UsersInfo;
import com.railway.railway.helper.JwtUtil;
import com.railway.railway.service.CustomUserDetailsService;


@RestController
@CrossOrigin(origins = "*")
public class JwtController {


	@Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    
    
    @Autowired
    private UserInfo userRepository;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<Object> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println("Inside Controller");
        System.out.println(jwtRequest);
        try {

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
           
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials 1");
        }catch (BadCredentialsException e)
        {
        	e.printStackTrace();
        	return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "status", "Incorrect UserName/Password provided. Please retry",
		            "status_code", HttpStatus.UNAUTHORIZED));
            
        }


        //fine area..
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT " + token);

        //{"token":"value"}

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "status", "Login Successful",
	            "status_code", HttpStatus.OK,
	            "User_id",this.userRepository.findByUsername(jwtRequest.getUsername()).getUser_id(),
        		"access_token",token));

    }

}


