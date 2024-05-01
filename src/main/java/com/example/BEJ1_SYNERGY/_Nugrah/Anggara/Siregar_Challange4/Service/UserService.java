package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;

import java.util.UUID;

public interface UserService {

    Users addUser(Users user);
    Users updateUser(Users user,UUID id);
    void deleteUser(UUID id);
}
