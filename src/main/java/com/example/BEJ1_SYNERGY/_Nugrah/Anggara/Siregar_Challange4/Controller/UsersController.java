package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Controller;


import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO.User.UserRequest;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO.User.UserResponse;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
@RequestMapping(path = "/user")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/registrasi")
    public UserResponse addUser(@RequestBody UserRequest user){
        return userService.addUser(user.getUsername(),user.getEmail(),user.getPassword());
    }

    @PutMapping(path = "/user/{id}")
    public Users updateUser(@RequestBody Users user,@PathVariable("id") UUID id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }
}
