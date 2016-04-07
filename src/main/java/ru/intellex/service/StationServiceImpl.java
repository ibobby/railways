package ru.intellex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intellex.model.Railway;
import ru.intellex.model.Station;
import ru.intellex.repository.RailwayRepository;
import ru.intellex.repository.StationRepository;

import java.util.List;

/**
 * Created by b.istomin on 14.05.2015.
 */
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository repository;

    @Override
    public List<Station> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Station> getAllWithRailways() {
        return repository.getAllWithRailways();
    }
}
