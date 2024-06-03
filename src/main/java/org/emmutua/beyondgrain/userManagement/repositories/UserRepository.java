package org.emmutua.beyondgrain.userManagement.repositories;

import org.bson.types.ObjectId;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<AppUser, ObjectId> {
    Optional<AppUser> findByEmail(String userEmail);
}