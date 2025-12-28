package com.nurul.RestAPIs.controller;


import com.nurul.RestAPIs.dto.LoginRequestDto;
import com.nurul.RestAPIs.dto.LoginResponseDto;
import com.nurul.RestAPIs.dto.SignupRequestDto;
import com.nurul.RestAPIs.security.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = authService.login(loginRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        try {
            authService.signUp(signupRequestDto);
            return new ResponseEntity<>("Signed Up!", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
