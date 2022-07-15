package org.example.domain.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    @Query("SELECT r " +
            "FROM RestaurantEntity r " +
            "WHERE UPPER(r.email) = UPPER(:email) " +
            "AND r.password = :password " +
            "AND r.exclusionDate IS NULl")
    Optional<RestaurantEntity> findByEmailAndPassword(String email, String password);
}
