package org.example.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.security.PayloadToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(PayloadToken payloadToken) {
        LocalDateTime expirationDateTime = LocalDateTime.now().plusDays(Long.parseLong(expiration));
        Instant instant = Instant.from(expirationDateTime.atZone(ZoneId.systemDefault()));
        Date expirationDate = Date.from(instant);
        return Jwts
                .builder()
                .setClaims(payloadToken.toHashMap())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(String token) {
        try {
            Claims claims = getClaims(token);
            Date expirationDate = claims.getExpiration();
            Instant instant = expirationDate.toInstant();
            LocalDateTime expirationDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
            return LocalDateTime.now().isBefore(expirationDateTime);
        } catch (Exception e) {
            return false;
        }
    }
}
