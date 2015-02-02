package org.analyzer.configuration.servlet;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.spring4.messageresolver.SpringMessageResolver;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.Set;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
public class ThymeleafConfiguration extends ApplicationObjectSupport {

    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(springTemplateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);

        return resolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(Set<? extends ITemplateResolver> templateResolvers, IMessageResolver messageResolver, Set<IDialect> dialects) {

        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();

        springTemplateEngine.setAdditionalDialects(dialects);
        springTemplateEngine.setMessageResolver(messageResolver);
        springTemplateEngine.setTemplateResolvers(templateResolvers);

        return springTemplateEngine;
    }

    @Bean
    public IMessageResolver springMessageResolver(MessageSource messageSource) {
        SpringMessageResolver springMessageResolver = new SpringMessageResolver();

        springMessageResolver.setMessageSource(messageSource);

        return springMessageResolver;
    }

    @Bean
    public IDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public IDialect thymeleafSpringDialect() {
        return new SpringStandardDialect();
    }

    @Bean
    public ITemplateResolver servletTemplateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setOrder(10);
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);

        return resolver;
    }

    @Bean ITemplateResolver deployTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        resolver.setPrefix("classpath:/views/");
        resolver.setOrder(20);
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(true);
        resolver.setCacheTTLMs(1000L);

        return resolver;
    }
}
