package com.prashant.smartfinancetracker.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean addUser(User user) {
        return userRepository.save(user) != null;
    }


}
