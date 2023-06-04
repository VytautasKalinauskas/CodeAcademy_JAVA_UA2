import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eu.codeacademy.javaua2.model.Product;
import eu.codeacademy.javaua2.model.Shop;
import org.junit.jupiter.api.Test;

class ShopTest {

	
	@Test
	void shopBalanceTest() throws FileNotFoundException {
		
		List<Product> products = Product.importProducts("products1.txt");
		
		Shop banginis = new Shop("Banginis", "Zirmunu 40", products);
		
		assertEquals(226.55,banginis.shopBalance());

	}
	
	@Test
	void sortShopByNameTest() {
		
		Shop banginis = new Shop("Banginis", "Zirmunu 40", null);
		Shop akropolis = new Shop("Akropolis", "Ozo 20", null);
		Shop mega = new Shop("Mega", "Islandijos plentas 192", null);
		Shop babilonas = new Shop("Babilonas", "Forsu 13", null);
		Shop eifelis = new Shop("Eifelis", "Zemaitijos 20", null);
		
		List<Shop> shops = new ArrayList<>(Arrays.asList(banginis, akropolis, mega, babilonas, eifelis));
		
		List<Shop> sortedShops = Shop.sortByName(shops);
		
		
		assertEquals("Akropolis", sortedShops.get(0).getName());
		
		assertEquals("Mega", sortedShops.get(4).getName());
		
		
	}

}
