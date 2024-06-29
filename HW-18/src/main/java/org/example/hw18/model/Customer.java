package org.example.hw18.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String birthday;
    private String gender;
    private String passport;
}
