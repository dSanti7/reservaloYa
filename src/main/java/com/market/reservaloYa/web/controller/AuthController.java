package com.market.reservaloYa.web.controller;

import com.market.reservaloYa.domain.dto.AuthenticationRequest;
import com.market.reservaloYa.domain.dto.AuthenticationResponse;
import com.market.reservaloYa.domain.service.ApplicationUserDetailsService;
import com.market.reservaloYa.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUser(), request.getPass()));

            UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(request.getUser());
            String jwt = jwtUtil.generatedToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException badCredentialsException) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
