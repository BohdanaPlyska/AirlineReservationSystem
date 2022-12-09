package com.example.demo.config;

import com.example.demo.exception.CustomFoundException;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@EnableWebSecurity
public class SecurityConfig {

    private  final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(@Lazy JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    private final static List<UserDetails> APP_USERS = Arrays.asList(
            new User(
                    "bohdana.plyska@gmail.com",
                    "$2a$10$a9pNxdtoDvxbU7tos.vGhuIPJQi71rDyc3flZrbslV6YUCmqoGGqe",
                    Collections.singleton(new SimpleGrantedAuthority("ADMIN"))
            ),
            new User(
                    "bohdashka.plyska@gmail.com",
                    "$2a$10$a9pNxdtoDvxbU7tos.vGhuIPJQi71rDyc3flZrbslV6YUCmqoGGqe",
                    Collections.singleton(new SimpleGrantedAuthority("USER"))
            )
    );

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    //authorization
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
                .antMatchers("/register").permitAll()
                .antMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider()) //use our authenticationProvider provider
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) //use jwt filter  before authenticate user
        ;
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return APP_USERS
                        .stream()
                        .filter(u  -> u.getUsername().equals(email))
                        .findFirst()
                        .orElseThrow(() -> new CustomFoundException("User not found"));
            }
        };
    }

}