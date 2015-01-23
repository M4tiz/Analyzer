package org.analyzer.configuration.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
@ComponentScan(basePackageClasses = RootConfiguration.class)
public class RootConfiguration {

}
