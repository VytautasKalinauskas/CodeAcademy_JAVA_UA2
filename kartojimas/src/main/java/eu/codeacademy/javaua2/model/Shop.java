package eu.codeacademy.javaua2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

	private String name;
	private String address;
	private List<Product> products;
	

	
	public Shop(String name, String address, List<Product> products) {
		super();
		this.name = name;
		this.address = address;
		this.products = products;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public Double shopBalance() {
		
		Double balance = 0.0;
		
		for(Product product : products) {
			Double productBalance = product.getPrice() * product.getRemainder();
			balance += productBalance;
		}
		
		return new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
	}
	
	
	public static List<Shop> sortByName(List<Shop> shops) {
		
		List<Shop> sortedShops = shops
				.stream()
				.sorted(Comparator.comparing(Shop::getName))
				.collect(Collectors.toList());
		
		return sortedShops;
		
		
	}
	
	
	
}
