package com.ecom.online.controller;

import com.ecom.online.entity.Product;
import com.ecom.online.model.ProductRequest;
import com.ecom.online.model.ProductResponse;
import com.ecom.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {

        Product product = productService.addProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PutMapping("/edit")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest productRequest){

        Product product = productService.updateProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }


    @GetMapping("/fetchAll")
    public List<ProductResponse> fetchAllProducts() {
        return productService.fetchAllProducts();
    }



    @GetMapping("/fetchById/{id}")
    public Product fetchByProductId(@PathVariable(name = "id") Long productId){

        Product product = productService.fetchProductById(productId);

        return product;
    }


    @GetMapping("/availableProducts")
    public  List<Product> fetchAvailableProducts(){

      return  productService.fetchAvailableProducts();
    }



}
