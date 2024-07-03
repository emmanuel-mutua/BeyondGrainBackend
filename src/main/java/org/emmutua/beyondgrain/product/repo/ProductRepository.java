package org.emmutua.beyondgrain.product.repo;

import org.emmutua.beyondgrain.product.model.Product;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByAppUser(AppUser appUser);
}
