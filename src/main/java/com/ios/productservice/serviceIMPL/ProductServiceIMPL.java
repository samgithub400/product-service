package com.ios.productservice.serviceIMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ios.productservice.dto.ProductRequest;
import com.ios.productservice.dto.ProductResponse;
import com.ios.productservice.model.Product;
import com.ios.productservice.repository.ProductRepository;
import com.ios.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceIMPL implements ProductService {

	private final ProductRepository productRepository;

	/*
	 * public ProductServiceIMPL(ProductRepository productRepository) {
	 * this.productRepository = productRepository;
	 * 
	 * //this is constructor bas injection manually instead of that we can
	 * use @RequiredArgsConstructor annotation from lombok...
	 * 
	 * }
	 */

	@Override
	public void createProduct(ProductRequest productRequest) {

		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();

		Product product1 = productRepository.save(product);
		// log.info("Product*****************:{}",product);
		log.info("Product saved : {}", product1);

	}

	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		return productList.stream().map(this::mapToProductResponse).toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
	}
}
