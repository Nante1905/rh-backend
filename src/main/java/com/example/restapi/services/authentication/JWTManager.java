package com.example.restapi.services.authentication;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import com.example.restapi.model.Utilisateur;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTManager {
    private static final String secret = "DvxMWzlQ2d6zSQ77EseNcGI1x0hhpCVJwtXBIx4c7uUlDSSRCD4kBXFyzEY2zLdN";
    private static final Key key = new SecretKeySpec(Base64.getDecoder().decode(secret),
            SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(Utilisateur utilisateur) {
        Date currentDate = new Date();

        String token = Jwts.builder()
                .setSubject(utilisateur.getUsername())
                .setIssuedAt(currentDate)
                .setExpiration(new Date(currentDate.getTime() + dayToMs(1)))
                .claim("roles", utilisateur.generateStringRoles())
                .claim("name", utilisateur.getNom() + " " + utilisateur.getPrenom())
                .signWith(key)
                .compact();
        return token;
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) throws AuthenticationCredentialsNotFoundException {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("Invalid token",
                    ex.fillInStackTrace());
        }
    }

    private long dayToMs(long day) {
        return 1000 * day * 24 * 60 * 60;
    }
}
