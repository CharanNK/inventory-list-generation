package com.example.inventorylists.controller;

import com.example.inventorylists.model.Items;
import com.example.inventorylists.model.JWTRequest;
import com.example.inventorylists.model.JWTResponse;
import com.example.inventorylists.service.ItemsDao;
import com.example.inventorylists.service.UserService;
import com.example.inventorylists.utility.JWTUtility;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    ItemsDao itemsDao;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Vasvamba Stores!";
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException bce){
            throw new Exception("Invalid Credentials");
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return new JWTResponse(token);
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Items> getAllItems() {
        return (List<Items>) itemsDao.findAll();
    }
}
