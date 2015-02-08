package org.analyzer.service.dialog;

import org.analyzer.domain.Dialog;
import org.analyzer.domain.LearningState;
import org.analyzer.persistence.dialog.DialogDAO;
import org.analyzer.service.category.DialogCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Service
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogDAO dialogDAO;

    @Override
    public DialogVO createNewDialog(DialogCategoryVO dialogCategory) {

        Dialog dialog = new Dialog();
        dialog.setDate(new Date());
        dialog.setDialogCategory(dialogCategory.getDomainObject());
        LearningState state = new LearningState();
        state.setDialog(dialog);
        dialog.setLearningState(state);

        dialogDAO.insert(dialog);

        return new DialogVO(dialog);
    }

    @Override
    public DialogVO save(DialogVO dialog) {
        Dialog domainObject = dialog.getDomainObject();
        if (domainObject.isNew()) {
            dialogDAO.insert(domainObject);
        } else {
            domainObject = dialogDAO.update(domainObject);
        }
        return new DialogVO(domainObject);
    }
}
