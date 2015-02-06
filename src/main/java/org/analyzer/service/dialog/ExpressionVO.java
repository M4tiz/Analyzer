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
}
