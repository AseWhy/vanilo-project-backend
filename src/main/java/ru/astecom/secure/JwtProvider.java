package ru.astecom.secure;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.astecom.DTO.user.AuthDTO;
import ru.astecom.service.UserService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Log4j2
@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    protected String jwtSecret;
    @Autowired
    protected UserService userService;

    public AuthDTO generateToken(String login, String password) {
        var result = new AuthDTO();
        var expires = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        var user = userService.login(login, password);

        result.setExpiresIn(expires.getEpochSecond());
        result.setToken(
            Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(Date.from(expires))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact()
        );

        return result;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(jwtSecret)
            .parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public String getLoginFromToken(String token) {
        return Jwts.parser()
            .setSigningKey(jwtSecret)
            .parseClaimsJws(token)
            .getBody()
        .getSubject();
    }
}