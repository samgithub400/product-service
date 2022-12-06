package com.ios.productservice.service;

import com.ios.productservice.dto.ProductRequest;
import com.ios.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
