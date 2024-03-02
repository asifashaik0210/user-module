package com.Usermodule.service;

import com.Usermodule.entity.Login;
import com.Usermodule.entity.UserRegistration;
import com.Usermodule.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existsByEmail(String email){
        boolean b = userRegistrationRepository.existsByEmail(email);
        return b;
    }
    public UserRegistration saveUser(UserRegistration userRegistration){
        UserRegistration save = userRegistrationRepository.save(userRegistration);
      return save;
    }

    public void authenticate(Login login) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

}
