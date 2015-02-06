package org.analyzer.service.dialog;

import org.analyzer.domain.Dialog;
import org.analyzer.service.ValueObject;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public class DialogVO extends ValueObject<Dialog> {

    public DialogVO(Dialog domainObject) {
        super(domainObject);
    }

    public Long getId() {
        return domainObject.getId();
    }

    public void finishDialog() {
        domainObject.getLearningState().setFinished();
    }

    public void addExpression(ExpressionVO expressionVO) {
        domainObject.addExpression(expressionVO.getDomainObject());
    }
}
