package ru.intellex.repository.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.intellex.model.Railway;
import ru.intellex.repository.RailwayRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by b.istomin on 26.03.2016.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class JpaRailwayRepositoryImpl implements RailwayRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Railway> getAll() {
        return em.createNamedQuery(Railway.ALL_SORTED, Railway.class).getResultList();
    }

    @Override
    public List<Railway> getAllWithStations() {
        return em.createNamedQuery(Railway.ALL_SORTED_WITH_STATIONS, Railway.class).getResultList();
    }


}
