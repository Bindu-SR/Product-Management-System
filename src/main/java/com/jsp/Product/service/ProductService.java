package com.jsp.Product.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.jsp.Product.dto.ProductDto;
import com.jsp.Product.entity.Product;
import com.jsp.Product.utility.ResponseStructure;


public interface ProductService {

    public ResponseEntity<ResponseStructure<Product>> addProduct(ProductDto productDto);
	
	
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);
	
	
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, ProductDto productDto);
	
	
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);
	
	
	public ResponseEntity<ResponseStructure<List<Product>>>findAllProducts();
}
