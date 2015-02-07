package org.analyzer.service.dialog;

import org.analyzer.domain.Expression;
import org.analyzer.service.ValueObject;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public class ExpressionVO extends ValueObject<Expression> {

    public ExpressionVO(Expression domainObject) {
        super(domainObject);
    }

    public String getContent() {
        return domainObject.getContent();
    }

    public static ExpressionVO from(DialogVO dialog, String expression) {
        Expression domainObject1 = new Expression();
        domainObject1.setContent(expression);
        domainObject1.setDialog(dialog.getDomainObject());
        return new ExpressionVO(domainObject1);
    }

    public void setDialog(DialogVO dialog) {
        domainObject.setDialog(dialog.getDomainObject());
    }
}
