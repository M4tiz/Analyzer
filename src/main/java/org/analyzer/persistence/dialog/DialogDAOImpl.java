package org.analyzer.persistence.dialog;

import org.analyzer.domain.Dialog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Repository
@Transactional
public class DialogDAOImpl implements DialogDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Dialog findById(Long id) {
        return null;
    }

    @Override
    public List<Dialog> findAll() {
        return null;
    }

    @Override
    public void insert(Dialog object) {
        entityManager.persist(object);
    }

    @Override
    public Dialog update(Dialog object) {
        return entityManager.merge(object);
    }

    @Override
    public void delete(Dialog object) {
        entityManager.remove(object);
    }
}
