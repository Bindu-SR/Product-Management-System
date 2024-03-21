package com.jsp.Product.serviceimpl;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.Product.dto.ProductDto;
import com.jsp.Product.entity.Product;
import com.jsp.Product.exception.ProductNotFoundByIdException;
import com.jsp.Product.repo.ProductRepository;
import com.jsp.Product.service.ProductService;
import com.jsp.Product.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService {

	
	private ProductRepository repo;
	private ResponseStructure<Product> structure;
	private ResponseStructure<List<Product>> structureList;
	
	
	public ProductServiceImpl(ProductRepository repo, ResponseStructure<Product> structure,
			ResponseStructure<List<Product>> structureList) {
		super();
		this.repo = repo;
		this.structure = structure;
		this.structureList = structureList;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductDto productDto) {
        
		Product product =  repo.save(mapToProduct(productDto, new Product()));
		
//		return ResponseEntity.status(HttpStatus.OK).body(structure);
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				                          .setMessage("Product Object Created Successfully!!")
				                          .setData(product));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
        
		    return repo.findById(productId).map((p)->{
			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
			
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					                                  .setMessage("Product Object Found!!")
					                                  .setData(p));
		}).orElseThrow(()-> new ProductNotFoundByIdException("Product Not Found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, ProductDto updatedProduct) {
        
		    return repo.findById(productId).map(exProduct->{
			Product product = repo.save(mapToProduct(updatedProduct, exProduct));
		
			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					                                  .setMessage("Product Object Updated!!")
					                                  .setData(product));
		}).orElseThrow(()-> new ProductNotFoundByIdException("Product not Found!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
        
		    return repo.findById(productId).map(p->{
			repo.delete(p);
			
			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					                                  .setMessage("Product Object Deleted!!")
					                                  .setData(p));
		}).orElseThrow(()-> new ProductNotFoundByIdException("Product not found!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		
		List<Product> products = repo.findAll();
		
//		it will return only responseStructure of product and not list<product>
//		products.stream().map((p)-> ResponseEntity.ok().body(structure.setData(p)));
		
		if(!products.isEmpty()) {
			return ResponseEntity.ok(structureList.setStatusCode(HttpStatus.OK.value())
					                              .setMessage("All Products Obtained")
					                              .setData(products));
		}
		else throw new RuntimeException();
	}
	
	//mapping of ProductDto to product
	private Product mapToProduct(ProductDto productDto, Product product) {
		
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		
		return product;
	}
}
