package com.example.service;

import java.util.Optional;

import com.example.model.MobileInternet;
import com.example.model.User;

public interface UserService {
	public User getUserData(String user, String password);
	
	public Optional<MobileInternet> getUserMi(String msisdn);
	
}
