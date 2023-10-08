package com.example.restapi.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.restapi.services.authentication.CustomUserDetailsService;
import com.example.restapi.services.authentication.JWTManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTInterceptor extends OncePerRequestFilter {

    @Autowired
    private JWTManager jwt;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = this.getJWTFromRequest(request);
        if (StringUtils.hasText(token)) {
            try {
                jwt.validateToken(token);
                String usename = jwt.getUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(usename);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                // authToken.setDetails(new
                // WebAuthenticationDetailsSource().buildDetails(request));
                // authToken.setAuthenticated(true);

                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (Exception e) {
                throw e;
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

}
