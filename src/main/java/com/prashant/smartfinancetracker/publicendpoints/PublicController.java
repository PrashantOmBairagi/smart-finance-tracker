package com.prashant.smartfinancetracker.publicendpoints;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
public class PublicController {

    @RequestMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
