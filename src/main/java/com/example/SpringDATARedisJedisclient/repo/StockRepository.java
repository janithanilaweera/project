package com.example.SpringDATARedisJedisclient.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDATARedisJedisclient.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,String> {

	List <Stock> findByLocation(String location);
	
}

