package org.example.service.address;

import org.example.domain.address.AddressEntity;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    void update(Long id, AddressEntity entity);
}
