package org.analyzer.controller;

/**
 * @author mateusz.rutski@sagiton.pl
 */

import org.analyzer.domain.DialogExpression;
import org.analyzer.service.category.DialogCategoryService;
import org.analyzer.service.category.DialogCategoryVO;
import org.analyzer.service.dialog.DialogExpressionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Known as 'BotController' in Sequence Diagram of 'Dialog conducting (Prowadzenie dialogu)' use case **/
@Component
public class BotEngine {

    private DialogCategoryVO currentDialogCategory;

    @Autowired
    private DialogCategoryService dialogCategoryService;

    public void initializeBot(DialogCategoryVO dialogCategory) {
        currentDialogCategory = dialogCategory;
    }

    public DialogExpressionVO getResponse(String expression) {
        checkInitialization();

        //TODO Expression analysis

        return new DialogExpressionVO(new DialogExpression());
    }

    public void finish() {
        checkInitialization();
        currentDialogCategory = null;
    }

    public void checkInitialization() {
        if (!isInitialized()) {
            throw new IllegalStateException("Bot must be initialized first");
        }
    }

    public boolean isInitialized() {
        return currentDialogCategory != null;
    }
}
