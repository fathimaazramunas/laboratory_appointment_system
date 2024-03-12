/*
package com.las.laboratory_appointment_system.seurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/doctor/**").hasAnyRole("DOCTOR", "ADMIN")
                .requestMatchers("/patient/**").hasAnyRole("PATIENT", "ADMIN")
                .requestMatchers("/labtechnician/**").hasAnyRole("LAB_TECHNICIAN", "ADMIN")
                .requestMatchers("/login", "/register", "/clubs", "/css/**", "/js/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("doctor").password("{noop}doctor").roles("DOCTOR")
                .and()
                .withUser("patient").password("{noop}patient").roles("PATIENT")
                .and()
                .withUser("labtechnician").password("{noop}labtechnician").roles("LAB_TECHNICIAN");
    }
}

*/
