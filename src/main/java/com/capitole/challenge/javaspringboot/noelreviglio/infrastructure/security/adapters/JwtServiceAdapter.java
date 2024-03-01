package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.security.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.application.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceAdapter implements JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long expiration;

    @Override
    public String generateToken( Object userDetails ){
        return this.generateToken( new HashMap<>(), userDetails );
    }

    @Override
    public String generateToken( Map<String, Object> extraClaims,
                                 Object userDetails ){
        var user = (UserDetails) userDetails;
        return Jwts.builder()
                .claims(extraClaims)
                .subject( user.getUsername())
                .issuedAt( new Date(System.currentTimeMillis()) )
                .expiration( new Date( System.currentTimeMillis() + this.expiration ) )
                .signWith( getSigningKey() )
                .compact();
    }

    @Override
    public boolean isTokenValid( String token, Object userDetails ){
        var user = (UserDetails) userDetails;
        final String username = extractUsername( token );
        return ( username.equalsIgnoreCase(user.getUsername()) )
                && !this.isTokenExpired( token );
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim( token, Claims::getSubject );
    }

    private boolean isTokenExpired(String token) {
        return this.extractExpiration( token ).isBefore( LocalDateTime.now() );
    }

    private LocalDateTime extractExpiration(String token) {
        final Date expirationToken = extractClaim( token, Claims::getExpiration);
        return LocalDateTime.ofInstant(
                expirationToken.toInstant(), ZoneId.systemDefault());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                    .verifyWith(this.getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode( secretKey );
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
