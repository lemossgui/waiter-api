package org.example.service.state;

import org.example.domain.state.StateEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateService {
    List<StateEntity> findAll();
}
