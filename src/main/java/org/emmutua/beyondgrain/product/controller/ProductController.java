package org.emmutua.beyondgrain.product.controller;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.product.dtos.ProductRequest;
import org.emmutua.beyondgrain.product.model.Product;
import org.emmutua.beyondgrain.product.service.ProductService;
import org.emmutua.beyondgrain.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/getSorted")
    ResponseEntity<List<Product>> getPagedAndSortedProducts(){
        var response = productService.getSorted();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/getProductById/{productId}")
    ResponseEntity<Product> getProductById(@PathVariable String productId){
        var response = productService.getProductById(productId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/getProductByUserId/{userId}")
    ResponseEntity<List<Product>> getUserProducts(@PathVariable String userId){
        var response = productService.getUserProducts(userId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/deleteProduct/{productId}")
    ResponseEntity<Response> deleteProduct(@PathVariable String productId){
        var response = productService.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }
}
