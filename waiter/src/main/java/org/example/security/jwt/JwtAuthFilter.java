package org.example.security.jwt;

import io.jsonwebtoken.Claims;
import org.example.security.PayloadToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class JwtAuthFilter extends BasicAuthenticationFilter {

    private final JwtService jwtService;

    @Autowired
    public JwtAuthFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.substring(7);
            boolean isValidToken = jwtService.isValidToken(token);
            if (isValidToken) {
                Claims claims = jwtService.getClaims(token);
                HashMap<String, Object> hashMap = new HashMap<>(claims);
                PayloadToken payloadToken = PayloadToken.fromHashMap(hashMap);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(payloadToken, null);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}
