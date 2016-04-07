package ru.intellex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intellex.model.Railway;
import ru.intellex.repository.RailwayRepository;

import java.util.List;

/**
 * Created by b.istomin on 14.05.2015.
 */
@Service
public class RailwayServiceImpl implements RailwayService {

    @Autowired
    private RailwayRepository repository;

    @Override
    public List<Railway> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Railway> getAllWithStations() {
        return repository.getAllWithStations();
    }

}
