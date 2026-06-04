package com.prashant.smartfinancetracker.user;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Validated
@ResponseBody
@RestController("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping()
    public User save(@Valid @RequestBody User user) {
        userService.addUser(user);
        return user;
    }

}
