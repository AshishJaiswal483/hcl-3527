
package com.abes.employeeapi.Security;

import com.abes.employeeapi.Service.CustomUserDetailService;
import com.abes.employeeapi.Service.JwtService;

import io.jsonwebtoken.JwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailService customUserDetailService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailService customUserDetailService) {

        this.customUserDetailService = customUserDetailService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        try {

            String userName = jwtService.extractUsername(token);

            UserDetails usersDetail =
                    customUserDetailService.loadUserByUsername(userName);

            boolean check = jwtService.isTokenValid(token, usersDetail);

            if (check) {

                UsernamePasswordAuthenticationToken authenticate =
                        new UsernamePasswordAuthenticationToken(
                                usersDetail,
                                null,
                                usersDetail.getAuthorities()
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(authenticate);

            } else {
                sendUnauthorizedResponse(response, "Invalid JWT");
                return;
            }

        } catch (JwtException e) {

            sendUnauthorizedResponse(response, "Invalid or expired JWT");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void sendUnauthorizedResponse(
            HttpServletResponse response,
            String message) throws IOException {

        SecurityContextHolder.clearContext();

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\"message\":\"" + message + "\"}"
        );
    }
}






