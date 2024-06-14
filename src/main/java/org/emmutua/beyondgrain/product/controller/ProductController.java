package org.emmutua.beyondgrain.product.controller;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.product.dtos.ProductRequest;
import org.emmutua.beyondgrain.product.service.ProductService;
import org.emmutua.beyondgrain.response.Response;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/upload_product")
    ResponseEntity<Response> uploadProduct(@RequestBody ProductRequest productRequest){
        var response = productService.uploadProduct(productRequest);
        return ResponseEntity.ok(response);
    }
}
