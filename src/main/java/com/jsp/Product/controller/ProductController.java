package com.jsp.Product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.Product.dto.ProductDto;
import com.jsp.Product.entity.Product;
import com.jsp.Product.service.ProductService;
import com.jsp.Product.utility.ResponseStructure;

@RestController
public class ProductController {

	private ProductService service;
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping(value = "/products")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody ProductDto productDto) {
		return service.addProduct(productDto);
	}
	
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
		return service.findByProductId(productId);
	}
	
	@PutMapping(value = "/products/{productId}")
	public  ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId, @RequestBody ProductDto productDto) {
		return service.updateByProductId(productId, productDto);
	}
	
	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>>  deleteByProductId(@PathVariable int productId) {
		return service.deleteByProductId(productId);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts(){
		return service.findAllProducts();
	}
}
