package org.analyzer.controller;

import org.analyzer.service.category.DialogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getCategoryListView(Model model) {

        model.addAttribute( "categories", dialogCategoryService.getCategoryList() );
        return CATEGORY_SELECT_VIEW;
    }
}
