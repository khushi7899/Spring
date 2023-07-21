package com.example.guestbook.domain.Service;

import com.example.guestbook.CustomMapper;
import com.example.guestbook.domain.Address;
import com.example.guestbook.domain.Guest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class GuestService {
    public GuestService(JdbcTemplate template) {
        this.template = template;
    }

    private JdbcTemplate template;



    public int createGuest(Guest guest) {
        String sql = "INSERT INTO GUEST(id,firstname,lastname,phone) VALUES(?,?,?,?); " ;
        String sql2  ="INSERT INTO ADDRESS(city,postal) VALUES(?,?)";
        template.update(sql2, guest.getAddress().getCity(),
                guest.getAddress().getPostalCode());
//         return template.update(sql,
//                guest.getId(),
//                guest.getFirstname(),
//                guest.getLastname(),
//                guest.getPhone());
        return 0;

    }

    public Guest update(Guest guest) {
        return null;
    }

    public Guest deleteGuest(int id) {
        return null;
    }

    public Guest getGuest(int id) {
        return null;
    }

    public List<Guest> getGuest() {
        return this.template.query("SELECT * FROM GUEST inner join ADDRESS ON GUEST.SN=ADDRESS.SN", new CustomMapper());
    }


}
