package org.analyzer.controller;

import org.analyzer.constants.HtmlViews;
import org.analyzer.service.user.UserService;
import org.analyzer.service.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.analyzer.constants.HttpPaths.ADD_USER;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @RequestMapping(value = ADD_USER, method = RequestMethod.GET)
    public String addUser(@PathVariable String username, @PathVariable String password, @PathVariable String role) {

        userService.addUser(UserVO.from(username, password, role));
        return HtmlViews.LOGIN;
    }
}
