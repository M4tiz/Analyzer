package org.analyzer.controller;

import org.analyzer.constants.HttpPaths;
import org.analyzer.service.category.DialogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.analyzer.constants.HtmlViews.CATEGORY_SELECT_VIEW;
import static org.analyzer.constants.HttpPaths.CATEGORY_SELECT;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
public class DialogCategoryController {


    @Autowired
    private DialogCategoryService dialogCategoryService;

    @RequestMapping(value = CATEGORY_SELECT)
    public String getCategoryListView(Model model, @RequestParam String action) {

        model.addAttribute( "categories", dialogCategoryService.getCategoryList() );
        model.addAttribute( "action",  action.equals("dialog") ? HttpPaths.DIALOG_START : HttpPaths.DIALOG_EXPRESSION_BROWSE);
        return CATEGORY_SELECT_VIEW;
    }
}
