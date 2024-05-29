package com.ecom.online.controller;

import com.ecom.online.entity.UserEntity;
import com.ecom.online.model.UserRequest;
import com.ecom.online.model.UserResponse;
import com.ecom.online.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<String> register(@RequestBody @Valid UserRequest userRequest) {
        String response ="";
        try {
            response= userService.registerUser(userRequest);
        }catch (Exception e){
            return new ResponseEntity<>("Error while register ::: "+e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam(name = "user") String userName, @RequestParam(name = "pass") String pass) {

        String response = userService.loginUser(userName, pass);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserResponse> getProfile(@PathVariable("id") Long id) {

        UserResponse profile = userService.getProfile(id);
        return new ResponseEntity<>(profile,HttpStatus.OK);


    }


}
