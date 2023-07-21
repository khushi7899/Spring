package com.example.guestbook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private Address address;

}
