package com.blog.Service;

import java.util.List;

import com.blog.DTO.UserDTO;

public interface UserService {
    
    UserDTO addUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO, Integer id);
    UserDTO getUserById(Integer id);
    List<UserDTO> getAllUsers();
    String deleteUser(Integer id);
    boolean findById(Integer id);
}
