package org.analyzer.persistence.dialog;

import com.mysema.query.jpa.impl.JPAQuery;

import org.analyzer.domain.Dialog;
import org.analyzer.domain.DialogExpression;
import org.analyzer.domain.QDialog;
import org.analyzer.domain.QDialogExpression;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

/**
 * @author wrabel
 */

@Repository
@Transactional
public class DialogExpressionDAOImpl implements DialogExpressionDAO {

    private static final QDialogExpression DIALOG_EXPRESSION = QDialogExpression.dialogExpression;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DialogExpression findById(Long id) {
        return null;
    }

    @Override
    public List<DialogExpression> findAll() {
        return new JPAQuery(entityManager)
                .from(DIALOG_EXPRESSION)
                .fetchAll()
                .list(DIALOG_EXPRESSION);
    }

    @Override
    public void insert(DialogExpression object) {
        entityManager.persist(object);
    }

    @Override
    public DialogExpression update(DialogExpression object) {
        return entityManager.merge(object);
    }

    @Override
    public void delete(DialogExpression object) {
        entityManager.remove(object);
    }
}
