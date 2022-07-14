package org.example.domain.service.state;

import org.example.domain.data.state.StateEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateService {
    List<StateEntity> findAll();
}
