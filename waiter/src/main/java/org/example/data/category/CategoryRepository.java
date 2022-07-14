package org.example.data.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    @Query("SELECT c " +
            "FROM CategoryEntity c " +
            "WHERE c.exclusionDate IS NULL " +
            "ORDER BY c.description ASC")
    List<CategoryEntity> findAll();
}
