//package com.example.demo.config;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//
//@Component
//public class AuthorizationFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain) throws ServletException, IOException {
//    final String authHeader = request.getHeader(AUTHORIZATION);
//    final String userEmail;
//
//        if (authHeader == null || !authHeader.startsWith("Basic")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//    }
//}