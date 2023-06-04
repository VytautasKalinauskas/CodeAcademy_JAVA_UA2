package eu.codeacademy.javaua2.model;

import eu.codeacademy.javaua2.exception.InsufficientProductException;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
public class Order {
	@BsonProperty(value = "order_nr")
	private String orderNr;
	private HashMap<String, Integer> orderedProducts;
	private OrderType type;

	public Order(String orderNr, HashMap<String, Integer> orderedProducts, OrderType type) {
		super();
		this.orderNr = orderNr;
		this.orderedProducts = orderedProducts;
		this.type = type;
	}
	
	public String getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(String orderNr) {
		this.orderNr = orderNr;
	}
	public HashMap<String, Integer> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(HashMap<String, Integer> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	public OrderType getType() {
		return type;
	}
	public void setType(OrderType type) {
		this.type = type;
	}
	
	
	public static List<Order> filterOrderByType(List<Order> orders, OrderType type) {
		
		List<Order> filteredOrders = orders
				.stream()
				.filter(order -> order.getType().equals(type))
				.collect(Collectors.toList());
		
		return filteredOrders;
		
	}
	
	public static void makeOrder(Shop shop, OrderType type, HashMap<String, Integer> products) throws InsufficientProductException {
		
		
		for(int i = 0; i < shop.getProducts().size(); i++) {
			
			if(products.containsKey(shop.getProducts().get(i).getBarcode())) {
				
				if(type.equals(OrderType.Purchase)) {
					Integer newRemainder = shop.getProducts().get(i).getRemainder() + products.get(shop.getProducts().get(i).getBarcode());
					shop.getProducts().get(i).setRemainder(newRemainder);
				}
				else {
					
					if(shop.getProducts().get(i).getRemainder() < products.get(shop.getProducts().get(i).getBarcode())) {
						throw new InsufficientProductException("Insufficient product " + shop.getProducts().get(i).getName() + " exception", shop.getProducts().get(i).getRemainder());
					}
					Integer newRemainder = shop.getProducts().get(i).getRemainder() - products.get(shop.getProducts().get(i).getBarcode());
					shop.getProducts().get(i).setRemainder(newRemainder);
				}
				
			}
			
		}

	}
	
}
