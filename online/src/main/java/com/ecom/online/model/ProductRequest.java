package com.ecom.online.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    @JsonProperty("productName")
    private String productName;

    @JsonProperty("price")
    private String price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isProductAvailable")
    private boolean isProductAvailable;

}
