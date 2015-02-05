package org.analyzer.service.dialog;

import org.analyzer.domain.DialogExpression;
import org.analyzer.service.ValueObject;

/**
 * @author mateusz.rutski@sagiton.pl
 */

public class DialogExpressionVO extends ValueObject<DialogExpression> {

    public DialogExpressionVO(DialogExpression domainObject) {
        super(domainObject);
    }

    public String getContent() {
        return domainObject.getContent();
    }
}
