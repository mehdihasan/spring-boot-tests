package me.mh.springtest.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                    .password("{noop}userpass")
                    .roles("USER")
                .and()
                .withUser("admin")
                    .password("{noop}adminpass")
                    .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/api/customers").permitAll()
                .mvcMatchers(HttpMethod.POST, "/api/customers").authenticated()
                .mvcMatchers(HttpMethod.GET, "/api/customers/*").authenticated()
                .mvcMatchers(HttpMethod.GET, "/dashboard").permitAll()
                .requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}