package com.example.nyaysathiBackend.model;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}
    public User(String username, String password, Role role){ this.username=username; this.password=password; this.role=role; }

    public Long getId(){ return id; }
    @Override public String getUsername(){ return username; }
    public void setUsername(String u){ username=u; }
    @Override public String getPassword(){ return password; }
    public void setPassword(String p){ password=p; }
    public Role getRole(){ return role; }
    public void setRole(Role r){ role = r; }

    @Override public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }
    @Override public boolean isAccountNonExpired(){ return true; }
    @Override public boolean isAccountNonLocked(){ return true; }
    @Override public boolean isCredentialsNonExpired(){ return true; }
    @Override public boolean isEnabled(){ return true; }
}
