package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.entity.RegisterBo;
import com.mvc.repository.MyRepository;

@Service
public class RegisterService {

	@Autowired
	private MyRepository repository;
	
	public RegisterBo insertData(RegisterBo  register) {
		
		System.out.println("Data Inserted!");
		
		return repository.save(register);
	}
	
	public List<RegisterBo> getData(){
		List<RegisterBo> all=repository.findAll();
		all.forEach(System.out::println);
		return all;
	}
	
}
