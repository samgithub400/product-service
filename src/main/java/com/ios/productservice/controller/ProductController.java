package com.ios.productservice.controller;

import com.ios.productservice.dto.ProductRequest;
import com.ios.productservice.dto.ProductResponse;
import com.ios.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

//       http://localhost:9091/api/product/create
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		log.info("createProduct call started with product:{}", productRequest);
		productService.createProduct(productRequest);
	}

//       http://localhost:9091/api/product/getall
	@GetMapping("/getall")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}

//   http://localhost:9091/api/product/test
	@GetMapping("/test")
	public String test() {
		return "OK..!";

	}
}
