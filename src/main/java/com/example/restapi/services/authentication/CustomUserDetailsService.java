package com.example.restapi.services.authentication;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Utilisateur;
import com.example.restapi.model.users.Role;
import com.example.restapi.services.UtilisateurService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = this.utilisateurService.findUtilisateurByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(utilisateur.getUsername(), utilisateur.getPassword(), createAuth(utilisateur.getRoles()));
    }

    private List<GrantedAuthority> createAuth(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNom())).collect(Collectors.toList());
    }

}
