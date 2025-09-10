package net.javaguides.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Tag(
        name = "Crud Rest APIs for User Resource",
        description = "Crud Rest APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create User Rest API",
            description = "Create User Rest API to save User in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CODE 201 CREATED"
    )
    // build Create user Rest API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User by Id Rest API",
            description = "Get User by Id Rest API to get a single User from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 SUCCESS"
    )
    // build Get User by ID Rest API
    // http://localhost:9090/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Users Rest API",
            description = "Get All UsersRest API to get all Users from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 SUCCESS"
    )
    // build Get All Users by ID Rest API
    // http://localhost:9090/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(
            summary = "Update User Rest API",
            description = "Update User API to update a particular User from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 SUCCESS"
    )
    // build Update user Rest API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto user,
                                              @PathVariable("id") Long userId) {
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser , HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User Rest API",
            description = "Delete User API to delete a particular User from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Student deleted successfully!" , HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

}
