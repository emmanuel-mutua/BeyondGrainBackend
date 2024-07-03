package org.emmutua.beyondgrain.product.service;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.exception.CustomException;
import org.emmutua.beyondgrain.mapper.ObjectMapper;
import org.emmutua.beyondgrain.product.dtos.ProductRequest;
import org.emmutua.beyondgrain.product.model.Product;
import org.emmutua.beyondgrain.product.model.ProductStatus;
import org.emmutua.beyondgrain.product.repo.ProductRepository;
import org.emmutua.beyondgrain.response.Response;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.emmutua.beyondgrain.userManagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Response uploadProduct(ProductRequest productRequest) {
        try {
            AppUser appUser = userRepository.findById(productRequest.getUserId()).orElseThrow();
            //save user to a product
            Product product = Product.builder().quantityInBags(productRequest.getQuantityInBags()).price(productRequest.getPrice()).discount(productRequest.getDiscount()).productStatus(ProductStatus.PENDING).imageUrls(productRequest.getImageUrl().get(0)).build();
            product.setAppUser(appUser);
            //save product
            productRepository.save(product);
            return new Response(
                    true, "Product added successfully"
            );
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<Product> getSorted() {
        return List.of();
    }

    @Override
    public Response deleteProduct(Long productId) {
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        try {
            return productRepository.findById(productId).orElseThrow();
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<Product> getUserProducts(Long userId) {
        try {
            AppUser appUser = userRepository.findById(userId).orElseThrow();
            return productRepository.findAllByAppUser(appUser);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}
