package com.marielagcw.health_center.service.impl;

import com.marielagcw.health_center.model.entity.Rol;
import com.marielagcw.health_center.model.entity.User;
import com.marielagcw.health_center.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService implements UserDetailsService {

    // DEPENDENCIES
    @Autowired
    IUserRepository userRepository;

    // METHODS
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByName(userName);

        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        GrantedAuthority autorizacion = null;
        for (Rol rol : user.get().getRoles()) {
            autorizacion = new SimpleGrantedAuthority("ROLE_" + rol.getName());
            autorizaciones.add(autorizacion);
        }
        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.get().getName(),
                "{noop}" + user.get().getPassword(),
                true,
                true,
                true,
                true,
                autorizaciones);
        return userDetail;
    }
}
