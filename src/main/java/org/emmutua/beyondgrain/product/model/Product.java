package org.emmutua.beyondgrain.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emmutua.beyondgrain.userManagement.model.AppUser;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long productId;
    private final String productName = "Maize";
    private Integer quantityInBags;
    private Double price;
    private Double discount;
    private ProductStatus productStatus;
    private String imageUrls;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "userId", name = "user_id")
    private AppUser appUser;
}
