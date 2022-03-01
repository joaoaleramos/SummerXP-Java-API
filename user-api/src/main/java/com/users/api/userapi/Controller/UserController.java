package com.users.api.userapi.Controller;

import java.util.UUID;

import com.users.api.userapi.Model.User;
import com.users.api.userapi.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/hello")
  public String hello(){
    return "Hello World";
  }

  @GetMapping("/")
  public ResponseEntity<Object> getUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getUser(@PathVariable UUID id){
      return ResponseEntity.ok().body(userService.getUser(id));
  }

  @PostMapping("/")
  public ResponseEntity<Object> createUser(@RequestBody User user){
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.saveUser(user));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateUser(@PathVariable ("id") UUID id, @RequestBody User user){

    return ResponseEntity.ok().body(userService.saveUser(user));
  }

}
