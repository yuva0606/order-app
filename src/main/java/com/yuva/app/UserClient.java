package com.yuva.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",url = "http://user-service:8080")
public interface UserClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}
