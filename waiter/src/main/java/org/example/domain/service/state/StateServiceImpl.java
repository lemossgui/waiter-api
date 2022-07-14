package org.example.domain.service.state;

import org.example.domain.data.state.StateEntity;
import org.example.domain.data.state.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record StateServiceImpl(
        StateRepository repository
) implements StateService {

    @Override
    public List<StateEntity> findAll() {
        return repository.findAll();
    }
}
