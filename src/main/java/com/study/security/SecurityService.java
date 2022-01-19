package com.study.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    SecurityUserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public SecurityUser createUser(String userName, String password) {
        SecurityUser user = new SecurityUser();
        user.setName(userName);
        user.setPassword(passwordEncoder.encode(password));

        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityUser> byName = repository.findByName(username);
        final SecurityUser user = byName.orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(user.getName(), user.getPassword(), authorities());
    }

    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
