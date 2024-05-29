package com.ecom.online.service;

import com.ecom.online.entity.Product;
import com.ecom.online.mapper.ProductMapper;
import com.ecom.online.model.ProductRequest;
import com.ecom.online.model.ProductResponse;
import com.ecom.online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public Product addProduct(ProductRequest productRequest) {

        //mapping request object to entity object
        Product productEntity = new Product();
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setProductavailable(productRequest.isProductAvailable());

        //use .save predefined method from jparepository
        Product save = productRepository.save(productEntity);
        return save;
    }

    @Override
    public List<ProductResponse> fetchAllProducts() {

        List<Product> listOfPorducts = productRepository.findAll();
        List<ProductResponse> productResponses = productMapper.entityToResponse(listOfPorducts);
        return productResponses;
    }

    @Override
    public Product updateProduct(ProductRequest productRequest) {

        Optional<Product> product = productRepository.findById(productRequest.getId());
        if (product.isPresent()) {
            Product productEntity = product.get();
            productEntity.setProductName(productRequest.getProductName());
            productEntity.setProductavailable(productRequest.isProductAvailable());
            productEntity.setDescription(productRequest.getDescription());
            productEntity.setPrice(productRequest.getPrice());
            Product save = productRepository.save(productEntity);
            if (save != null) {

                return save;
            }

        }

        return null;
    }

    @Override
    public String deleteProduct(Long id) {

        productRepository.deleteById(id);
        return "Product removed from the list";
    }

    @Override
    public Product fetchProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        return product.get();
    }

    @Override
    public List<Product> fetchAvailableProducts() {

        List<Product> byIsProductAvailable = productRepository.findByIsProductavailable(true);
        
        return  byIsProductAvailable;

    }
}
