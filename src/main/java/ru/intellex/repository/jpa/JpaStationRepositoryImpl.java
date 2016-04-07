package ru.intellex.repository.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.intellex.model.Railway;
import ru.intellex.model.Station;
import ru.intellex.repository.RailwayRepository;
import ru.intellex.repository.StationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by b.istomin on 26.03.2016.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class JpaStationRepositoryImpl implements StationRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Station> getAll() {
        return em.createNamedQuery(Station.ALL_SORTED, Station.class).getResultList();
    }

    @Override
    public List<Station> getAllWithRailways() {
        return em.createNamedQuery(Station.ALL_SORTED_WITH_RAILWAYS, Station.class).getResultList();
    }

}
