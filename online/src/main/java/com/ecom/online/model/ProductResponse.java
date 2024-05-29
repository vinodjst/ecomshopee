package com.ecom.online.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String productName;

    private String price;

    private String description;

    private boolean isProductAvailable;
}
