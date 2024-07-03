package org.emmutua.beyondgrain.userManagement.token;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    //find all valid token by a user
    List<Token> findAllByExpiredFalseAndRevokedFalse();
    Optional<Token> findByToken(String token);
}
