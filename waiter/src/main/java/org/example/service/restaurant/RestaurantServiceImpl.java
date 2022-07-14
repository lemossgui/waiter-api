package org.example.service.restaurant;

import lombok.RequiredArgsConstructor;
import org.example.controller.exception.NotFoundException;
import org.example.data.address.AddressRepository;
import org.example.data.restaurant.RestaurantEntity;
import org.example.data.restaurant.RestaurantRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public void save(RestaurantEntity entity) {
        addressRepository.save(entity.getAddress());
        repository.save(entity);
    }

    @Override
    public void update(Long id, RestaurantEntity entity) {
        RestaurantEntity found = findById(id);
        entity.setId(found.getId());
        entity.setPassword(found.getPassword());
        entity.setAddress(found.getAddress());
        repository.save(entity);
    }

    @Override
    public Page<RestaurantEntity> findAll(RestaurantEntity filter, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<RestaurantEntity> example = Example.of(filter, matcher);
        return repository.findAll(example, pageable);
    }

    @Override
    public RestaurantEntity findById(Long id) {
        Optional<RestaurantEntity> found = repository.findById(id);
        return found.orElseThrow(() -> new NotFoundException("Restaurante não encontrado"));
    }
}
