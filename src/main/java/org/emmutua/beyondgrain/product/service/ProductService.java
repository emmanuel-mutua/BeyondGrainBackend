package org.emmutua.beyondgrain.product.service;

import org.emmutua.beyondgrain.product.dtos.ProductRequest;
import org.emmutua.beyondgrain.product.model.Product;
import org.emmutua.beyondgrain.response.Response;

import java.util.List;

public interface ProductService {
    Response uploadProduct(ProductRequest productRequest);

    List<Product> getSorted();

    Response deleteProduct(Long productId);

    Product getProductById(Long productId);

    List<Product> getUserProducts(Long userId);
}
