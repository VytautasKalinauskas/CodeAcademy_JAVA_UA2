package eu.codeacademy.mvc.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.codeacademy.mvc.eshop.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

	@GetMapping("/products/open")
	public String openCreateProductForm(Model model) {
		var product = new Product();
		product.setName("Perduotas ledas");
		model.addAttribute("product", product);
		return "product";
	}

	@PostMapping("/products/open")
	public String createProduct(Model model, Product product) {
		return "product";
	}
}
