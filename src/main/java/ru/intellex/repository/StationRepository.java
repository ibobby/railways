package ru.intellex.repository;


import ru.intellex.model.Railway;
import ru.intellex.model.Station;

import java.util.List;

/**
 * Created by b.istomin on 26.03.2016.
 */
public interface StationRepository {

    List<Station> getAll();

    List<Station> getAllWithRailways();

}
