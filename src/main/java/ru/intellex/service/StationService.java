package ru.intellex.service;

import ru.intellex.model.Railway;
import ru.intellex.model.Station;

import java.util.List;

/**
 * Created by b.istomin on 05.04.2016.
 */
public interface StationService {

    public List<Station> getAll();

    public List<Station> getAllWithRailways();

}
