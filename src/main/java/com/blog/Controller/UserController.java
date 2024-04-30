package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.ApiResponse.ApiResponse;
import com.blog.DTO.UserDTO;
import com.blog.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.addUser(userDTO),HttpStatus.CREATED);
    }


    @PutMapping("user/{id}")
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer id){
        return userService.updateUser(userDTO, id);
    }

    
    @GetMapping("user/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Integer id){
        if(!userService.findById(id)){
            System.out.println("No user found..");
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "No user found with id "+id),HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "User with id "+id+" found.",userService.getUserById(id)) ,HttpStatus.OK);
    }

    @GetMapping("user")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        if(!userService.findById(id)){
            return new ResponseEntity<>("User not found with Id "+id+" to delete.",HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
