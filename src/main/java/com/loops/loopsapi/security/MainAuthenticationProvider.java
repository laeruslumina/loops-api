package com.loops.loopsapi.security;

import com.loops.loopsapi.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class MainAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public Authentication authenticate (Authentication authentication) throws AuthenticationException{
        return userRepository
                .findByEmail(authentication.getName())
                .filter(user -> passwordEncoder.matches(((String) authentication.getCredentials()), user.getPassword()))
                .map(user -> new UsernamePasswordAuthenticationToken(
                        user,
                        authentication.getCredentials(),
                        Collections.emptyList()
                    )
                )
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Username %s not found", authentication.getName())
                ));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
