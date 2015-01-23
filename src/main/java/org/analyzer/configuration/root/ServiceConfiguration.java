package org.analyzer.configuration.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
@ComponentScan(basePackages = {"org.analyzer.service"})
public class ServiceConfiguration {

}
