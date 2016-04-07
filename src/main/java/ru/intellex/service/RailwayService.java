package ru.intellex.service;


import ru.intellex.model.Railway;

import java.util.List;

/**
 * Created by b.istomin on 15.05.2015.
 */
public interface RailwayService {

    public List<Railway> getAll();

    public List<Railway> getAllWithStations();

}
