package org.example.domain.data.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

    @Override
    @Query("SELECT s " +
            "FROM StateEntity s " +
            "WHERE s.exclusionDate IS NULL " +
            "ORDER BY s.description ASC")
    List<StateEntity> findAll();
}
