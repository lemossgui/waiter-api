package org.example.service.costumer;

import org.example.domain.costumer.CostumerEntity;
import org.springframework.stereotype.Service;

@Service
public interface CostumerService {
    void save(CostumerEntity entity);

    void update(Long id, CostumerEntity entity);

    CostumerEntity findById(Long id);
}
