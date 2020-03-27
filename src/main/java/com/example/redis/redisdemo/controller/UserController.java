package com.example.redis.redisdemo.controller;

import com.example.redis.redisdemo.dao.User;
import com.example.redis.redisdemo.service.AuthorizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private AuthorizationService authorizationService;

  @PostMapping(value = "/addUser")
  public ResponseEntity<String> addUSer(@RequestBody User user) {

    ModelMapper modelMapper = new ModelMapper();
    User usermodel = modelMapper.map(user, User.class);

    Boolean result = authorizationService.saveUser(usermodel);
    if (result) {
      return ResponseEntity.ok("A new user is saved!");
    } else {
      return ResponseEntity.ok("An error occured!!");
    }
  }

  @PostMapping(value = "/findUser")
  public ResponseEntity findUser(@RequestBody User user) {

    ModelMapper modelMapper = new ModelMapper();
    User userModel = modelMapper.map(user, User.class);
    User result = authorizationService.findByName(userModel.getName());
    return ResponseEntity.ok(result);
  }

}
