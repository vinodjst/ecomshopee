package com.ecom.online.mapper;

import com.ecom.online.entity.Product;
import com.ecom.online.model.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductResponse> entityToResponse(List<Product> productEntity);
}
