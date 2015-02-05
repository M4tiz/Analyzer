package org.analyzer.controller;

import org.analyzer.service.category.DialogCategoryService;
import org.analyzer.service.category.DialogCategoryVO;
import org.analyzer.service.dialog.DialogService;
import org.analyzer.service.dialog.DialogVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.analyzer.constants.HtmlViews.DIALOG_VIEW;
import static org.analyzer.constants.HttpPaths.DIALOG_INPUT;
import static org.analyzer.constants.HttpPaths.DIALOG_START;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
public class DialogController {

    @Autowired
    private BotEngine botEngine;

    @Autowired
    private DialogCategoryService dialogCategoryService;

    @Autowired
    private DialogService dialogService;

    @RequestMapping(value = DIALOG_START, method = RequestMethod.GET)
    public String startDialog(@PathVariable Long categoryId, Model model) {

        DialogCategoryVO category = dialogCategoryService.findById(categoryId);
        botEngine.initializeBot(category);
        DialogVO newDialog = dialogService.createNewDialog(category);

        model.addAttribute("category", category);
        model.addAttribute("dialogId", newDialog.getId());

        return DIALOG_VIEW;
    }

    @RequestMapping(value = DIALOG_INPUT, method = RequestMethod.POST)
    @ResponseBody
    public String queryExpression(@RequestParam String expression) {

        if (StringUtils.isBlank(expression)) {
            throw new IllegalStateException("Expression cannot be null");
        }

        return botEngine.getResponse(expression).getContent();
    }
}
