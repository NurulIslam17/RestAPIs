package com.nurul.RestAPIs.security;

import com.nurul.RestAPIs.entity.User;
import com.nurul.RestAPIs.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    public JwtAuthFilter(UserRepository userRepository, AuthUtil authUtil) {
        this.userRepository = userRepository;
        this.authUtil = authUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = requestTokenHeader.substring(7); // "Bearer ".length() = 7
        String userName = authUtil.getUserNameFromToken(token);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {
            User user = userRepository.findByUserName(userName).orElseThrow();
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        filterChain.doFilter(request,response);

    }
}
