package com.jay.localservices.security; // package where this class belongs

import io.jsonwebtoken.Claims; // used to extract data from token
import io.jsonwebtoken.Jwts; // main JWT builder/parser
import io.jsonwebtoken.SignatureAlgorithm; // algorithm used for signing
import io.jsonwebtoken.security.Keys; // helps create secure signing key

import org.springframework.stereotype.Component; // makes this a spring bean

import java.security.Key; // key used to sign token
import java.util.Date; // used for token expiration


@Component
public class JwtUtil {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkey12345";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)   // <-- ADD THIS
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    private Claims getClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {

        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}