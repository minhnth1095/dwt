package com.fpts.fitint.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserDetails usser) {
        return Jwts.builder()
                .subject(usser.getUsername())
                .claim("role", usser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+3600000))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
    public List<String> extractRoles(String token) {

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role", List.class);
    }
    public String extractUsername(String token){

        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token) {try {

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

        return true;

    } catch (Exception e) {
        return false;
    }
    }
}
