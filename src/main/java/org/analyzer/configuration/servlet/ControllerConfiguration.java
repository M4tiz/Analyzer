package org.analyzer.configuration.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
@ComponentScan(basePackages = {"org.analyzer.controller"})
public class ControllerConfiguration {
}
