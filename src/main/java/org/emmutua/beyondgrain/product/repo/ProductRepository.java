package org.emmutua.beyondgrain.product.repo;

import org.bson.types.ObjectId;
import org.emmutua.beyondgrain.product.model.Product;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    List<Product> findAllByAppUser(AppUser appUser);
}
