//package com.example.demo.config;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
//        new User(
//                "admin",
//                "password",
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
//        ),
//            new User(
//                    "user",
//                    "password",
//                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
//            )
//    );
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .authenticationProvider(authenticationProvider())
//                .httpBasic();
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//                return APPLICATION_USERS
//                        .stream()
//                        .filter(u -> u.getUsername().equals(email))
//                        .findFirst()
//                        .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
//            }
//        };
//    }
//
//}