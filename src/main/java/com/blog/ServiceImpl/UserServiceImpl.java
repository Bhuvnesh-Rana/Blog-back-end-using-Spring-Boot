package com.blog.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.DTO.UserDTO;
import com.blog.Entity.User;
import com.blog.Repository.UserRepository;
import com.blog.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User SavedUser = userRepo.save(user);

        return userToDto(SavedUser);
        // User user1 = dtoToUser(userDTO);             //=this.        if does not work (check mthd below public or private)
        // User SavedUser = userRepo.save(user1);       //=this.
        // return userToDto(SavedUser);                 //return this.
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        User user = userRepo.findById(id).get();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User SavedUser = userRepo.save(user);
        return userToDto(SavedUser);

    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepo.findById(id).get();
        return userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> qwert= users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
        return qwert;

    }

    @Override
    public String deleteUser(Integer id) {
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
        return "User with Id "+user.getId()+" deleted.";
    }


    public User dtoToUser(UserDTO userdto){
        User user=new User();
        user.setId(userdto.getId());                //CAN USE MODELMAPPER INSTEAD. used in category.
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setAbout(userdto.getAbout());

        return user;
    }

    public UserDTO userToDto(User user){
        UserDTO userdto=new UserDTO();
        userdto.setId(user.getId());                //CAN USE MODEL MAPPER INSTAD.
        userdto.setName(user.getName());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        userdto.setAbout(user.getAbout());

        return userdto;
    }

    @Override
    public boolean findById(Integer id) {
        return userRepo.findById(id).isPresent();
    }
    
    
}
