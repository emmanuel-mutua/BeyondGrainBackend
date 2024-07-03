package org.emmutua.beyondgrain.userManagement.repositories;

import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.emmutua.beyondgrain.userManagement.model.UserType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String userEmail);
    boolean existsAppUserByEmailOrIdNoOrPhone(String userEmail, String idNo, String phone);
    List<AppUser> findAllByRole(UserType userType, Pageable pageable);
}