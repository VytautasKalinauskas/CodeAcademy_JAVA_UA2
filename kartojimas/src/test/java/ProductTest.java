import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

import eu.codeacademy.javaua2.model.Product;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	@Test
	void importProductsTest() throws FileNotFoundException {
		
		List<Product> products = Product.importProducts("products1.txt");
		assertEquals(5, products.size());
		
		assertEquals("Varske",products.get(0).getName());
		
	}
	

}
