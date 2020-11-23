package com.hedgehogs.dclub.controller;

import com.hedgehogs.dclub.model.Product;
import com.hedgehogs.dclub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/product/saveProduct")
	public Product saveProduct(@RequestBody Product product){
		productRepository.save(product);
		return product;
	}

	@GetMapping("/product/findAll")
	public List<Product> all() {
		Iterator<Product> iterator = productRepository.findAll().iterator();
		List<Product> products = new ArrayList<>();
		while (iterator.hasNext()) {
			products.add(iterator.next());
		}
		return products;
	}

	@GetMapping("/product/findByPrice/{price}")
	public Product findProductByPrice(@PathVariable String price) { return (Product) productRepository.findByPrice(price);	}

	@GetMapping("/product/findByPriceByCustomQuery/{price}")
	public List<Product> findProductByProductUsingCustomQuery (@PathVariable String price) { return (List<Product>) productRepository.findByPriceUsingCustomQuery(price);	}

	@GetMapping("/product/findByPriceFiltered/{price}")
	public List<Product> findProductByPriceByFilteredQuery (@PathVariable String price) { return (List<Product>) productRepository.findByFilteredPriceQuery(price); }
}
