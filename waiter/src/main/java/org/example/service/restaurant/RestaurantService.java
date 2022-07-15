package org.example.service.restaurant;

import org.example.domain.restaurant.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantService {
    void save(RestaurantEntity entity);

    void update(Long id, RestaurantEntity entity);

    Page<RestaurantEntity> findAll(RestaurantEntity filter, Pageable pageable);

    RestaurantEntity findById(Long id);
}
