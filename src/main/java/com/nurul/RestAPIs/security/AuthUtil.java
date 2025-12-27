package com.nurul.RestAPIs.security;

import com.nurul.RestAPIs.entity.User;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    //Define this in environment setup or .yaml file
    private String jwtSecretKey = "hdwgDGWKJ3468&#@*EE^@E&(@EVWGDWDGWEDGDScript*@&#^E@@E(*DRUDGED)(@#*$(*LDJjdfh";

    private SecretKey generateSecreteKey()
    {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    String generateAccessToken(User user)
    {
        return Jwts.builder()
                .subject(user.getUserName())
                .claim("userId",user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10))
                .signWith(generateSecreteKey())
                .compact();
    }
}
