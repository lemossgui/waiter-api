package org.example.service.address;

import lombok.RequiredArgsConstructor;
import org.example.rest.exception.NotFoundException;
import org.example.domain.address.AddressEntity;
import org.example.domain.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public void update(Long id, AddressEntity entity) {
        Optional<AddressEntity> optional = repository.findById(id);
        AddressEntity found = optional.orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
        entity.setId(found.getId());
        repository.save(entity);
    }
}
