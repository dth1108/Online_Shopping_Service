package com.example.quizpractice.common.sso.jwt;
/*******************************************************
 * For Vietnamese readers:
 *    Các bạn thân mến, mình rất vui nếu project này giúp 
 * ích được cho các bạn trong việc học tập và công việc. Nếu 
 * bạn sử dụng lại toàn bộ hoặc một phần source code xin để 
 * lại dường dẫn tới github hoặc tên tác giá.
 *    Xin cảm ơn!
 *******************************************************/

//import com.example.demo.user.CustomUserDetails;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Collections;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Copyright 2019 {@author Loda} (https://loda.me). This project is licensed under the MIT license.
 *
 * @since 5/1/2019 Github: https://github.com/loda-kun
 */
@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwtSecret}")
    private String JWT_SECRET;
    private final long JWT_EXPIRATION = 604800000L;

    public String generateToken(Authentication authentication) {
        // Lấy thông tin user
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.token.Invalid JWT token")
                            .params(Collections.singletonList(authToken))
                            .build());
        } catch (ExpiredJwtException ex) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.token.Expired JWT token")
                            .params(Collections.singletonList(authToken))
                            .build());
        } catch (UnsupportedJwtException ex) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.token.Unsupported JWT token")
                            .params(Collections.singletonList(authToken))
                            .build());
        } catch (IllegalArgumentException ex) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.token.JWT claims string is empty.")
                            .params(Collections.singletonList(authToken))
                            .build());
        }
    }
}
