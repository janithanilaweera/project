package com.example.SpringDATARedisJedisclient.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDATARedisJedisclient.model.Price;
import com.example.SpringDATARedisJedisclient.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, String> {

	
	List<User> findByLocation(String location);
	List<User> findByNama(String nama);
}