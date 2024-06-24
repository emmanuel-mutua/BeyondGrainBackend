package org.emmutua.beyondgrain.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String userId;
    private Integer quantityInBags;
    private Double price;
    private Double discount;
    private List<String> imageUrl;

    public ObjectId getUserID() {
        return new ObjectId(this.userId);
    }
}
