package com.hd.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
    @Autowired
    HttpSecurity httpSecurity;

    @Bean
    SecurityFilterChain settingUpHttpSecurity() throws Exception {
        // httpSecurity.authorizeHttpRequests((auth) ->
        // auth.anyRequest().authenticated());
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/users").permitAll());
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/todos").denyAll());
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/todo").authenticated());
        httpSecurity.formLogin();
        httpSecurity.httpBasic();
        return httpSecurity.build();
    }

    @Bean
    HandlerMappingIntrospector handlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }

}
