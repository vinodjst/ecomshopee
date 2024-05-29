package com.ecom.online.service;

import com.ecom.online.entity.Product;
import com.ecom.online.model.ProductRequest;
import com.ecom.online.model.ProductResponse;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductRequest productRequest);

    List<ProductResponse> fetchAllProducts();

    Product updateProduct(ProductRequest productRequest);

    String deleteProduct(Long id);

    Product fetchProductById(Long id);

    List<Product> fetchAvailableProducts();
}
