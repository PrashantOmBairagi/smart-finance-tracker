package com.prashant.smartfinancetracker.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }
    public void completeProfile(CompleteProfileRequest request) {

        SecurityContext context = SecurityContextHolder.getContext();
        UUID userId = (UUID) context.getAuthentication().getPrincipal();

        User user = userRepository.findById(userId).orElseThrow();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBudget(request.getBudget());
        user.setPhone(request.getPhone());
        userRepository.save(user);
    }
    public User getUser(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }


}
