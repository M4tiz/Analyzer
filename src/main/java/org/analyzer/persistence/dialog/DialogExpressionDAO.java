package org.analyzer.persistence.dialog;

import org.analyzer.domain.DialogExpression;
import org.analyzer.persistence.DataAccessObject;

import java.util.List;

/**
 * @author wrabel
 */
public interface DialogExpressionDAO extends DataAccessObject<DialogExpression> {

    List<DialogExpression> findByCategoryIdWithoutAnswer(Long categoryId);
}
