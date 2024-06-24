package org.emmutua.beyondgrain.product.service;

import org.emmutua.beyondgrain.product.dtos.ProductRequest;
import org.emmutua.beyondgrain.product.model.Product;
import org.emmutua.beyondgrain.response.Response;

import java.util.List;

public interface ProductService {
    Response uploadProduct(ProductRequest productRequest);

    List<Product> getSorted();

    Response deleteProduct(String productId);

    Product getProductById(String productId);

    List<Product> getUserProducts(String userId);
}
