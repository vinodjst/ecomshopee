package com.ecom.online.mapper;

import com.ecom.online.entity.Product;
import com.ecom.online.model.ProductResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-27T08:17:44+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductResponse> entityToResponse(List<Product> productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( productEntity.size() );
        for ( Product product : productEntity ) {
            list.add( productToProductResponse( product ) );
        }

        return list;
    }

    protected ProductResponse productToProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductName( product.getProductName() );
        productResponse.setPrice( product.getPrice() );
        productResponse.setDescription( product.getDescription() );

        return productResponse;
    }
}
