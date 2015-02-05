package org.analyzer.persistence.category;

import com.mysema.query.jpa.impl.JPAQuery;
import org.analyzer.domain.DialogCategory;
import org.analyzer.domain.QDialogCategory;
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
public class DialogCategoryDAOImpl implements DialogCategoryDAO {

    private final QDialogCategory DIALOG_CATEGORY = QDialogCategory.dialogCategory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DialogCategory findById(Long id) {
        return new JPAQuery(entityManager)
                .from(DIALOG_CATEGORY)
                .where(DIALOG_CATEGORY.id.eq(id))
                .singleResult(DIALOG_CATEGORY);
    }

    @Override
    public List<DialogCategory> findAll() {
        return new JPAQuery(entityManager)
                .from(DIALOG_CATEGORY)
                .list(DIALOG_CATEGORY);
    }

    @Override
    public void insert(DialogCategory object) {
        entityManager.persist(object);
    }

    @Override
    public DialogCategory update(DialogCategory object) {
        return entityManager.merge(object);
    }

    @Override
    public void delete(DialogCategory object) {
        entityManager.remove(object);
    }
}
