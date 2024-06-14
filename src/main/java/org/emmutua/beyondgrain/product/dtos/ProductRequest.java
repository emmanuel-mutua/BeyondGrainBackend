package org.emmutua.beyondgrain.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emmutua.beyondgrain.product.model.ProductStatus;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer quantityInBags;
    private Double price;
    private Double discount;
    private ProductStatus productStatus;
    private List<String> imageUrl;
}
