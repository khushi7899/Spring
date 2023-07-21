package com.example.guestbook;

import com.example.guestbook.domain.Address;
import com.example.guestbook.domain.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomMapper implements RowMapper<Guest> {

    @Override
    public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Guest.builder()
                .id(rs.getInt("ID"))
                .firstname(rs.getString("FIRSTNAME"))
                .lastname(rs.getString("LASTNAME"))
                .phone(rs.getString("PHONE"))
                .address(Address.builder()
                        .postalCode(rs.getString("POSTAL"))
                        .city(rs.getString("City"))
                        .build())
                .build();

    }
}
