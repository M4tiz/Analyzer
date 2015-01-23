package org.analyzer.configuration.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ViewResolver;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
public class ThymeleafConfiguration extends ApplicationObjectSupport {

    @Bean
    public ViewResolver viewResolver() {
        return null;
    }
}
