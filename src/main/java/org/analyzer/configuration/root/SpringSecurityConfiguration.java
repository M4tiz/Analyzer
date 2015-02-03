package org.analyzer.configuration.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.analyzer.constants.HttpPaths.*;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .sessionManagement()
                .invalidSessionUrl(LOGIN)
                .sessionFixation()
                .newSession()

                .and()
                .exceptionHandling()
                .accessDeniedPage(HTTP_ERROR)

                .and()
                .formLogin()
                .loginPage(LOGIN)
                .failureUrl(LOGIN_FAILED)
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl(DASHBOARD)
                .permitAll()

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT, "GET"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl(LOGIN)
                .permitAll()

                .and()
                .authorizeRequests()
                .regexMatchers(HTTP_ERROR).permitAll()
                .regexMatchers(LOGIN_REQUEST).permitAll()
                .regexMatchers("/*").authenticated();
    }
}
