//package com.dwill.gamestore.model.user;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.ollection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class MyUserDetails implements UserDetails {
//
//    private String userName;
//    private String password;
//    private boolean active;
//    private UserRole userRole;
//
//    public MyUserDetails(AppUser user) {
//        this.userName = user.getUsername();
//        this.password = user.getPassword();
//        this.active = user.isEnabled();
//        this.userRole = user.getUserRole();
//    }
//
//    public MyUserDetails() {
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public String getPassword() { return "pass"; }
//}
