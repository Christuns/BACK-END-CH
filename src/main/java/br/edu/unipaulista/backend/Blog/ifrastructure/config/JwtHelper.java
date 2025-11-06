package br.edu.unipaulista.backend.Blog.ifrastructure.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.Jwts.parserBuilder;

@Component
public class JwtHelper  {
    private final String SECRET = "CHAVE_SECRETA_SUPER_SECRETA";
    private final int TOKEN_EXPIRANTION_MS = 1000*60*60*24*2;

    public String generateToken(UserDetails userDetails){

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRANTION_MS))
                .signWith(this.getSinginKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getSinginKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token){
        return parserBuilder()
                .setSigningKey(this.getSinginKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration().before(new Date());
    }

    private Key getSinginKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
