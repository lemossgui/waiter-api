package org.example.domain.costumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostumerRepository extends JpaRepository<CostumerEntity, Long> {

    @Query("SELECT c " +
            "FROM CostumerEntity c " +
            "WHERE UPPER(c.email) = UPPER(:email) " +
            "AND c.password = :password " +
            "AND c.exclusionDate IS NULl")
    Optional<CostumerEntity> findByEmailAndPassword(String email, String password);
}
