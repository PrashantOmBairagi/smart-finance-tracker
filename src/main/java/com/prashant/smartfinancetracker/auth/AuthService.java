package com.prashant.smartfinancetracker.auth;

import com.prashant.smartfinancetracker.security.JwtService;
import com.prashant.smartfinancetracker.user.User;
import com.prashant.smartfinancetracker.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public ResponseEntity<?> register(AuthRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            Map<String,String> error = new HashMap<>();
            error.put("message", "Email already exists! Try Login.");
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setProfileComplete(false);

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok().body(new AuthResponse(token,"Registration Successful", user.isProfileComplete()));
    }
}
