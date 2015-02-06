package org.analyzer.service.dialog;

import org.analyzer.service.category.DialogCategoryVO;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public interface DialogService {
    DialogVO createNewDialog(DialogCategoryVO dialogCategory);

    DialogVO save(DialogVO dialog);
}
