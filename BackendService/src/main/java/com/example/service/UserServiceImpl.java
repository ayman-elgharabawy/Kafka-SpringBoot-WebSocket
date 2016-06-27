package com.example.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MobileInternet;
import com.example.model.User;
import com.example.repository.MobileInternetRepository;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired(required=true)
	UserRepository userRepo;
	
	@Autowired(required=true)
	MobileInternetRepository miRepo;
	
	
	@Override
	public User getUserData(String user,String password) {
		User usr=userRepo.findOneByMsisdn(user);
		return usr;
	}


	@Override
	public Optional<MobileInternet> getUserMi(String msisdn) {
		logger.info("getUserMi(msisdn: {}) starts...", msisdn);
		Optional<MobileInternet> result = miRepo.findByUserName(msisdn);
		logger.info("getUserMi(msisdn: {}) done, result: {}", msisdn, result);
		return result;
	}
}
