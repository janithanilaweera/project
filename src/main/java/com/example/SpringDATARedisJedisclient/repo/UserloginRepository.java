package com.example.SpringDATARedisJedisclient.repo;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;


import com.example.SpringDATARedisJedisclient.model.Userlogin;

public interface UserloginRepository extends CrudRepository<Userlogin,Map<String,String>>{
	 Userlogin findByUserName(String userName);
}