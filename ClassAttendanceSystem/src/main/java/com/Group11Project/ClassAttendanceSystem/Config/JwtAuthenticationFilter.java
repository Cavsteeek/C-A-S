package com.Group11Project.ClassAttendanceSystem.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String userName;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // If there's an Authorization header with Bearer token, you may choose to handle it here.
            // For this example, we'll ignore it and proceed with regular authentication.
            filterChain.doFilter(request, response);
            return;
        }

        // Extract username and password from request (modify this according to your request structure)
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // You can modify this part to perform your custom authentication logic
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    password,
                    userDetails.getAuthorities()
            );
            authentication = authenticationManager.authenticate(authentication);

            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
    private boolean isValidPassword(UserDetails userDetails, String password) {
        return userDetails.getPassword().equals(password);
    }
}
