package com.chaitanya.csc_center.config;

import com.chaitanya.csc_center.service.CustomerUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfig {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/api/**") // Skip CSRF for REST API calls
        ) // Disable CSRF for testing (or configure it properly)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/index", "/login", "/register", "/css/**", "/js/**", "/images/**", "/api/services/**", "/services").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/appointments/book").permitAll() // <-- Allow POST explicitly
            .requestMatchers("/admin/**", "/admin/services/**").hasRole("ADMIN")
            .requestMatchers("/user/**").hasRole("USER")
            .anyRequest().authenticated()
        )
            .formLogin(login -> login
                .loginPage("/login")
                .successHandler(customSuccessHandler)
                .permitAll()
            )
            .exceptionHandling(e -> e
                .accessDeniedPage("/access-denied")
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))

            );

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(CustomerUserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
