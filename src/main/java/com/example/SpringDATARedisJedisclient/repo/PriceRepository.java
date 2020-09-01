package com.example.SpringDATARedisJedisclient.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDATARedisJedisclient.model.Price;
//import com.sun.tools.javac.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, String> {

	//Student findByFirstname(String string);

	
	
	List<Price> findByLocation(String location);
}