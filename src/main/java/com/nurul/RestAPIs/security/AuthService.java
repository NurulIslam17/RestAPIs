package com.nurul.RestAPIs.security;


import com.nurul.RestAPIs.dto.LoginRequestDto;
import com.nurul.RestAPIs.dto.LoginResponseDto;
import com.nurul.RestAPIs.dto.SignupRequestDto;
import com.nurul.RestAPIs.entity.User;
import com.nurul.RestAPIs.entity.type.RoleType;
import com.nurul.RestAPIs.mail.MailService;
import com.nurul.RestAPIs.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final PasswordEncoder passwordEncoder;

    private final MailService mailService;

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, AuthUtil authUtil, PasswordEncoder passwordEncoder, MailService mailService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.authUtil = authUtil;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
    }


    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(user.getUserName(), user.getEmail(), token);

    }

    public void signUp(SignupRequestDto signupRequestDto) {

        User user = userRepository.findByUserName(signupRequestDto.getUserName()).orElse(null);
        if (user != null) {
            throw new IllegalArgumentException("User already exist");
        }
        User newUser = new User();
        newUser.setUserName(signupRequestDto.getUserName());
        newUser.setEmail(signupRequestDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        newUser.setRoles(signupRequestDto.getRoles());
        userRepository.save(newUser);
        mailService.sendMail(newUser.getEmail(), "Registration Confirmation", "Your registration successfully completed.");

    }
}
