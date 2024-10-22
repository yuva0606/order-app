package com.yuva.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private UserClient userClient;

    @GetMapping("/test")
    public String testRun(){
        return "hey there";
    }

    @PostMapping
    public Order createOrder(@RequestParam Long userId, @RequestParam String product) {
        // Get user details from the User Service
        User user = userClient.getUserById(userId);

        // Create a new order
        Order order = new Order();
        order.setUserId(userId);
        order.setProduct(product);

        return orderRepository.save(order);
    }
}

