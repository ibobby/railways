package ru.intellex.repository;


import ru.intellex.model.Railway;
import java.util.List;

/**
 * Created by b.istomin on 26.03.2016.
 */
public interface RailwayRepository {

    List<Railway> getAll();

    List<Railway> getAllWithStations();

}
