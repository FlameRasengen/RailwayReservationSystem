package com.railway.railway.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.railway.railway.dao.UserInfo;
import com.railway.railway.entities.CustomUserDetails;
import com.railway.railway.entities.UsersInfo;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
    private UserInfo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		final UsersInfo user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found !!");
        } else {
            return new CustomUserDetails(user);
        }
//		if(username.equals("ankit"))
//		{
//			return (UserDetails) new User("ankit","123", new ArrayList<>());
//		}
//		else
//		{
//			throw new UsernameNotFoundException("User Not found!!");
//		}
	}

	public CustomUserDetailsService(UserInfo userRepository) {
		super();
		this.userRepository = userRepository;
	}

}
