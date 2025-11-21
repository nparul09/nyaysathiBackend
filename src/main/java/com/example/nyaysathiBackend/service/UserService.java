package com.example.nyaysathiBackend.service;

import com.example.nyaysathiBackend.model.Role;
import com.example.nyaysathiBackend.repo.UserRepository;
import com.example.nyaysathiBackend.model.User;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {

        if (repo.findByUsername("citizen") == null) {
            repo.save(new User("citizen", passwordEncoder.encode("password"), Role.CITIZEN));
        }

        if (repo.findByUsername("lawyer") == null) {
            repo.save(new User("lawyer", passwordEncoder.encode("password"), Role.LAWYER));
        }

        if (repo.findByUsername("judge") == null) {
            repo.save(new User("judge", passwordEncoder.encode("password"), Role.JUDGE));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return repo.findByUsername(username);
    }
}
