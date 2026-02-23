package com.rlmua.landtracking.service;

import com.rlmua.landtracking.dto.request.LoginRequest;
import com.rlmua.landtracking.dto.request.SignupRequest;
import com.rlmua.landtracking.dto.response.AuthResponse;
import com.rlmua.landtracking.entity.AdminUser;
import com.rlmua.landtracking.enums.Role;
import com.rlmua.landtracking.repository.AdminUserRepository;
import com.rlmua.landtracking.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public void signup(SignupRequest request) {
        if (adminUserRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException("Username already exists");
        }

        AdminUser user = AdminUser.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.ADMIN)
                .build();

        adminUserRepository.save(user);
        log.info("New admin user registered: {}", request.username());
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UserDetails user = userDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(user);
        log.info("Admin user logged in: {}", request.username());

        return new AuthResponse(token);
    }
}
