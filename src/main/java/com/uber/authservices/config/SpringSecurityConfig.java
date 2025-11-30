package com.uber.authservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    //formLogin
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/services/v1/auth/signup/*", "/services/v1/auth/signin/*")
//                        .permitAll().anyRequest().authenticated()).formLogin(form ->
//                        form.loginPage("/services/v1/auth/signin/passenger")
//                                .loginProcessingUrl("/services/v1/auth/signin/passenger")
//                                .usernameParameter("email")
//                                .passwordParameter("password")
//                                .defaultSuccessUrl("/services/v1/auth/signin/passenger", true)
//                                .permitAll()
//                )
//                .build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("kaish@gmail.com")
                        .password(passwordEncoder().encode("reza1234"))
                        .roles("USER").build()
        );
    }

    @Bean
    public ApiKeyAuthProvider apiKeyAuthProvider(UserDetailsService userDetailsService) {
        return new ApiKeyAuthProvider(userDetailsService, passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(ApiKeyAuthProvider provider){
        return new ProviderManager(List.of(provider));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager manager) throws Exception {
        ApiAuthFilter apiAuthFilter = new ApiAuthFilter(manager);

        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/services/v1/auth/signup/*", "/services/v1/auth/signin/*")
                        .permitAll().anyRequest().authenticated())
                .addFilterBefore(apiAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
