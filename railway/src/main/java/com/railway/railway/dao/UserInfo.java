package com.railway.railway.dao;

import org.springframework.data.jpa.repository.JpaRepository;



import com.railway.railway.entities.UsersInfo;


public interface UserInfo extends JpaRepository<UsersInfo, Integer> {

	public UsersInfo findByUsername(String username);
}
