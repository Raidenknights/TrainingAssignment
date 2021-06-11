package com.example.MyWeb.UserService.Stocks;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock,Integer> {
	Stock findByCompany(String Company);
	Stock deleteByCompany(String Company);
}
