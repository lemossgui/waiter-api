package org.example.service.costumer;

import lombok.RequiredArgsConstructor;
import org.example.controller.exception.NotFoundException;
import org.example.data.address.AddressRepository;
import org.example.data.costumer.CostumerEntity;
import org.example.data.costumer.CostumerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CostumerServiceImpl implements CostumerService {

    private final CostumerRepository repository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public void save(CostumerEntity entity) {
        addressRepository.save(entity.getAddress());
        repository.save(entity);
    }

    @Override
    public void update(Long id, CostumerEntity entity) {
        CostumerEntity found = findById(id);
        entity.setId(found.getId());
        entity.setPassword(found.getPassword());
        entity.setAddress(found.getAddress());
        repository.save(entity);
    }

    @Override
    public CostumerEntity findById(Long id) {
        Optional<CostumerEntity> found = repository.findById(id);
        return found.orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }
}
