package org.analyzer.configuration.root;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Order(1)
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {


}
