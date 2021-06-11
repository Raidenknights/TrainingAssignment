package com.example.MyWeb.UserService.Stocks;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyWeb.UserService.UserModel.UserNotFound;
import com.example.MyWeb.UserService.UserModel.WrongCredentials;

@RestController
public class StockController {
	
	@Autowired
	StockRepository stockRepo;
	

	
	@GetMapping(path="/getStock/{Company}")
	public ResponseEntity<Object> getStocks(@PathVariable String Company){
		
		Stock stk = stockRepo.findByCompany(Company);
		System.out.println(stk);
		if(stk==null) {
			throw new UserNotFound("No company with the given name");
		}
		return new ResponseEntity(stk,HttpStatus.FOUND);
	}
	@PostMapping(path="/createStock")
	public ResponseEntity<Object> createStock(@Valid @RequestBody Stock stock){
		
		stockRepo.save(stock);
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@PutMapping(path="/updateStock")
	public ResponseEntity<Object> update(@Valid @RequestBody Stock stock){
		
		stockRepo.deleteByCompany(stock.getCompany());
		stockRepo.save(stock);
		 
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	@DeleteMapping(path="/deleteStock/{company}")
	public ResponseEntity<Object> delete(@PathVariable String company ){
		Stock stk = stockRepo.findByCompany(company);
		if(stk==null) {
			throw new WrongCredentials("Company do not exist");
		}
		stockRepo.deleteByCompany(company);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllStocks")
	public List<Stock> getAll(){
		
		return stockRepo.findAll();
	}
}
