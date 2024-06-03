package org.emmutua.beyondgrain.userManagement.token;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, ObjectId> {
    //find all valid token by a user
    List<Token> findAllByExpiredFalseAndRevokedFalse();
    Optional<Token> findByToken(String token);
}
