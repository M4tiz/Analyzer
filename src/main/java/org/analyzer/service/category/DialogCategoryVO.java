package org.analyzer.service.category;

import org.analyzer.domain.DialogCategory;
import org.analyzer.service.ValueObject;

/**
 * @author mateusz.rutski@sagiton.pl
 */

public class DialogCategoryVO extends ValueObject<DialogCategory> {


    public DialogCategoryVO(DialogCategory domainObject) {
        super(domainObject);
    }

    public Long getId() {
        return domainObject.getId();
    }

    public String getName() {
        return domainObject.getName();
    }
}
