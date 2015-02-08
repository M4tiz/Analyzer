package org.analyzer.controller;

import org.analyzer.constants.HtmlViews;
import org.analyzer.constants.HttpPaths;
import org.analyzer.service.category.DialogCategoryService;
import org.analyzer.service.dialog.DialogExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
public class DialogExpressionController {

    @Autowired
    private DialogExpressionService dialogExpressionService;

    @Autowired
    private DialogCategoryService dialogCategoryService;

    @ModelAttribute("expressions")
    public List<String> getDialogExpressions(@PathVariable Long categoryId) {
        return dialogExpressionService.getUserExpressionsByCategoryId(categoryId);
    }

    @ModelAttribute("category")
    public String getCategory(@PathVariable Long categoryId) {
        return dialogCategoryService.findById(categoryId).getName();
    }

    @RequestMapping(value = HttpPaths.DIALOG_EXPRESSION_BROWSE, method = RequestMethod.GET)
    public String dialogExpressionsView(@PathVariable Long categoryId) {
        return HtmlViews.DIALOG_EXPRESSIONS_BROWSE_VIEW;
    }
}
