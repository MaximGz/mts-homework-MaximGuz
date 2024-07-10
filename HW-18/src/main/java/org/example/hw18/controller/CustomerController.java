package org.example.hw18.controller;

import lombok.AllArgsConstructor;
import org.example.hw18.model.Customer;
import org.example.hw18.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/v1/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String allCustomers(Model model) {
        List<Customer> customers = customerService.getCustomerList();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/v1/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_USER')")
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
}
