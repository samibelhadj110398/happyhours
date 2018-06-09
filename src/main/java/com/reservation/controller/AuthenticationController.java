package com.reservation.controller;

import com.reservation.config.JwtTokenUtil;
import com.reservation.model.AuthToken;
import com.reservation.model.LoginAdmin;
import com.reservation.model.utilisteur.Admin;
import com.reservation.service.utilisateur.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("api/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "api/token/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginAdmin loginadmin) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginadmin.getUsername(),
                		loginadmin.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Admin user = adminService.findOne(loginadmin.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token));
    }

}
