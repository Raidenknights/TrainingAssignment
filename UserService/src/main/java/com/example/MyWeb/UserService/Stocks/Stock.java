package com.example.MyWeb.UserService.Stocks;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Stocks")
public class Stock {
	@Id
	private int idStock;
	private String company;
	private double buyPrice;
	public Stock() {
		super();
	}
	public Stock(int idStock, String company, double buyPrice, int quantity) {
		super();
		this.idStock = idStock;
		this.company = company;
		this.buyPrice = buyPrice;
	}
	public int getIdStock() {
		return idStock;
	}
	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	
}
