package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build Create user Rest API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
    }

    // build Get User by ID Rest API
    // http://localhost:9090/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    // build Get All Users by ID Rest API
    // http://localhost:9090/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    // build Update user Rest API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,
                                              @PathVariable("id") Long userId) {
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Student deleted successfully!" , HttpStatus.OK);
    }

}
