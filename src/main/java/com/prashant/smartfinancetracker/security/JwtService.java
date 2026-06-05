package com.prashant.smartfinancetracker.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${JWT_SECRET}")
    private String jwtSecret;

}
