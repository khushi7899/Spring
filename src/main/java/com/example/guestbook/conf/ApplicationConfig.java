package com.example.guestbook.conf;

import com.example.guestbook.domain.Guest;
import com.example.guestbook.domain.Address;
import com.example.guestbook.domain.Service.GuestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("guestapp.properties")
public class ApplicationConfig {

    @Bean
    public Guest guest(@Value("${guest.id}") int id,
                       @Value("${guest.firstName}") String firstname,
                       @Value("${guest.lastName}") String lastname,
                       @Value("${guest.phone}") String phone,
                       @Value("${guest.address.city}") String city,
                       @Value("${guest.address.postal}")String postal)

    {
        return Guest.builder()
                .id(id)
                .firstname(firstname)
                .lastname(lastname)
                .phone(phone)
                .address(Address.builder()
                        .city(city)
                        .postalCode(postal)
                        .build())
                .build();
    }
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder=DataSourceBuilder.create();
        builder.url("jdbc:h2:./appdb");
        builder.username("sa");
        builder.password("");
        return builder.build();
    }
}
