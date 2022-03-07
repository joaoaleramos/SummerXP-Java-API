package com.users.api.userapi.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.users.api.userapi.Model.User;
import com.users.api.userapi.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @RestController
  @RequestMapping("/api/cliente")
  public class ClienteController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);
      });
      return errors;
    }

  }

  @GetMapping("/")
  public ResponseEntity<Object> getUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @PostMapping("/post/")
  public ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.saveUser(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getUser(@PathVariable("id") UUID id) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getUser(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUser(@PathVariable("id") UUID id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateUser(@PathVariable("id") UUID id, @RequestBody @Valid User user) {
    return ResponseEntity.ok().body(userService.updateUser(id, user));
  }

}