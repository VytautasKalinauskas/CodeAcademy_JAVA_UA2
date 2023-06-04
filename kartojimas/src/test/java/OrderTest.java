import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import eu.codeacademy.javaua2.exception.InsufficientProductException;
import eu.codeacademy.javaua2.model.Order;
import eu.codeacademy.javaua2.model.OrderType;
import eu.codeacademy.javaua2.model.Product;
import eu.codeacademy.javaua2.model.Shop;
import org.junit.jupiter.api.Test;

class OrderTest {

	
	@Test
	public void filterOrderByTypeTest() {
		
		Order order1 = new Order("Nr1", null, OrderType.Purchase);
		Order order2 = new Order("Nr2", null, OrderType.Purchase);
		Order order3 = new Order("Nr3", null, OrderType.Purchase);
		Order order4 = new Order("Nr4", null, OrderType.Purchase);
		Order order5 = new Order("Nr5", null, OrderType.Sale);
		Order order6 = new Order("Nr6", null, OrderType.Sale);
		
		List<Order> orders = new ArrayList<>(Arrays.asList(order1,order2,order3,order4,order5,order6));
		
		
		assertEquals(4, Order.filterOrderByType(orders, OrderType.Purchase).size());
		
		assertEquals(2, Order.filterOrderByType(orders, OrderType.Sale).size());	
		
		
	}
	
	
	@Test
	public void makeOrderTestPurchase() throws FileNotFoundException, InsufficientProductException {
		
		List<Product> products = Product.importProducts("products1.txt");
		
		Shop banginis = new Shop("Banginis", "Zirmunu 40", products);
		
		HashMap<String, Integer> order = new HashMap<>();
		
		order.put("07886659844", 5);
		order.put("06669844723", 7);
		
		
		Order.makeOrder(banginis, OrderType.Purchase, order);
		
		assertEquals(11, products.get(0).getRemainder());
		assertEquals(9, products.get(1).getRemainder());
		
		
	}
	
	
	@Test
	public void makeOrderTestSale() throws FileNotFoundException, InsufficientProductException {
		
		List<Product> products = Product.importProducts("products1.txt");
		
		Shop banginis = new Shop("Banginis", "Zirmunu 40", products);
		
		HashMap<String, Integer> order = new HashMap<>();
		
		
		order.put("07886659844", 2);
		order.put("06669844723", 2);
		
		Order.makeOrder(banginis, OrderType.Sale, order);
		
		assertEquals(4, products.get(0).getRemainder());
		assertEquals(0, products.get(1).getRemainder());
		
		
	}
	
	
	@Test
	public void makeOrderTestSaleInsufficientProductException() throws FileNotFoundException, InsufficientProductException {
		
		List<Product> products = Product.importProducts("products1.txt");
		
		Shop banginis = new Shop("Banginis", "Zirmunu 40", products);
		
		HashMap<String, Integer> order = new HashMap<>();
		
	
		order.put("06669844723", 5);
		
		
		InsufficientProductException exception = assertThrows(InsufficientProductException.class, () -> {
			Order.makeOrder(banginis, OrderType.Sale, order);
		  });

		
		assertEquals(2, exception.getRemainder());
		
		
	}
	

}
