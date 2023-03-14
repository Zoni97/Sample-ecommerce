package it.sonia.ecommerce.dao;

import it.sonia.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    UserRepository repository;
/*
    public final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
        new User(
            "rev_xx@live.it",
            "pw",
            Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
        ),
        new User(
            "rev_xxuser@live.it",
            "password",
            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        )
    );

    public UserDetails findUserByEmail(String email){
        return APPLICATION_USERS
            .stream()
            .filter(u-> u.getUsername().equals(email))
            .findFirst()
            .orElseThrow(() -> new UsernameNotFoundException("No user was found"))
        ;
    } */
}
