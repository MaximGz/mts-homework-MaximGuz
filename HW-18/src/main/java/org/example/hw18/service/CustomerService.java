package org.example.hw18.service;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.example.hw18.model.Customer;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

@Getter
@Service
public class CustomerService {
    private final List<Customer> customerList;

    public CustomerService() {
        Faker faker = new Faker(new Locale("ru"));
        customerList = IntStream.rangeClosed(1,10)
                .mapToObj(i -> Customer.builder()
                        .id(i)
                        .name(faker.name().fullName())
                        .phone(faker.bothify("+79#########"))
                        .email(faker.bothify("????##@gmail.com"))
                        .address(faker.address().fullAddress().replace("#",""))
                        .gender(new Random().nextInt(2) == 0 ? "M" : "F")
                        .birthday(faker.date().birthday(20, 65).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        .passport(faker.bothify("## ####"))
                        .build())
                .toList();
    }

    @PostConstruct
    public void test() {
        customerList.forEach(System.out::println);
    }

    public Customer getRandomCustomer() {
        return customerList.get(new Random().nextInt(customerList.size()));
    }

    public Customer getCustomerById(int id) {
        return customerList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
