package org.analyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;

}
