package org.example.service.costumer;

import lombok.RequiredArgsConstructor;
import org.example.domain.address.AddressRepository;
import org.example.domain.costumer.CostumerEntity;
import org.example.domain.costumer.CostumerRepository;
import org.example.rest.exception.NotFoundException;
import org.example.utils.CryptUtils;
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
        entity.setPassword(CryptUtils.md5(entity.getPassword()));
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
