package com.example.careermap.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                		.antMatchers("/api/v1/utilisateur/save").permitAll()
                        .antMatchers("/api/v1/utilisateur/login").permitAll()
                        .antMatchers("/api/v1/utilisateur/fetchQuestions").permitAll()
                        .antMatchers("/api/v1/utilisateur/reponses").permitAll()
                        .antMatchers("/api/v1/utilisateur/personality/{userId}/{testId}").permitAll()
                        .anyRequest().authenticated());           
    }
}

