package org.emmutua.beyondgrain.product.service;

import org.emmutua.beyondgrain.product.dtos.ProductRequest;
import org.emmutua.beyondgrain.response.Response;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;

public interface ProductService {
    Response uploadProduct(ProductRequest productRequest);
}
