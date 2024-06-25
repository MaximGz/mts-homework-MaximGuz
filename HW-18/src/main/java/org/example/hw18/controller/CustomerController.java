package org.example.hw18.controller;

import lombok.AllArgsConstructor;
import org.example.hw18.model.Customer;
import org.example.hw18.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/v1/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> allCustomers() {
        return customerService.getCustomerList();
    }

    @GetMapping("/v1/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "It's welcome page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/newlogin")
    public String newlogin() {
        return "newlogin";
    }
}
