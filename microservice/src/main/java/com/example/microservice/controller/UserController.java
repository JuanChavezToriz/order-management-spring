package com.example.microservice.controller;

import com.example.microservice.dto.UserDto;
import com.example.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable long userId, @RequestBody UserDto userDto) {
        UserDto updated = userService.updateByUserId(userId,userDto);
        return ResponseEntity.ok(updated);
    }

}
