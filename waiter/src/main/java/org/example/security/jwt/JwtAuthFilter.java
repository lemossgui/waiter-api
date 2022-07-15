package org.example.security.jwt;

import io.jsonwebtoken.Claims;
import org.example.security.PayloadToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Autowired
    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) {
        try {
            String authorization = request.getHeader("Authorization");
            if (authorization != null && authorization.startsWith("Bearer")) {
                String tokenHeader = authorization.substring(7);
                UsernamePasswordAuthenticationToken auth = getAuthentication(tokenHeader);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            chain.doFilter(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) throws UsernameNotFoundException {
        if (jwtService.isValidToken(token)) {
            Claims claims = jwtService.getClaims(token);
            HashMap<String, Object> hashMap = new HashMap<>(claims);
            PayloadToken payloadToken = PayloadToken.fromHashMap(hashMap);
            return new UsernamePasswordAuthenticationToken(payloadToken, null, null);
        } else {
            throw new UsernameNotFoundException("Token Inválido");
        }
    }
}
