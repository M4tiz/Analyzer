package org.analyzer.controller;

import org.analyzer.constants.HtmlViews;
import org.analyzer.constants.HttpPaths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
public class DashboardController {

    @RequestMapping(value = HttpPaths.DASHBOARD, method = RequestMethod.GET)
    public String dashboard() {
        return HtmlViews.DASHBOARD;
    }
}
