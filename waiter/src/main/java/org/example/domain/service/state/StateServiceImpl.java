package org.example.domain.service.state;

import lombok.RequiredArgsConstructor;
import org.example.domain.data.state.StateEntity;
import org.example.domain.data.state.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository repository;

    @Override
    public List<StateEntity> findAll() {
        return repository.findAll();
    }
}
