package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Controller;


import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
@RequestMapping(path = "/user")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/registrasi")
    public Users addUser(@ModelAttribute Users user){
        return userService.addUser(user);
    }

    @PutMapping(path = "/user/{id}")
    public Users updateUser(@ModelAttribute Users user,@PathVariable("id") UUID id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }
}
