package org.emmutua.beyondgrain.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Long userId;
    private Integer quantityInBags;
    private Double price;
    private Double discount;
    private List<String> imageUrl;
}
