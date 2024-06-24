package org.emmutua.beyondgrain.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private ObjectId productId;
    private final String productName = "Maize";
    private Integer quantityInBags;
    private Double price;
    private Double discount;
    private ProductStatus productStatus;
    private List<String> imageUrls;
    @DBRef(lazy = true)
    private AppUser appUser;
}
