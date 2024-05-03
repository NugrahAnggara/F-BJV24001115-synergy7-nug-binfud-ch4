package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO.User.UserResponse;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public UserResponse addUser(String username, String email, String password) {
        userRepository.registrationUser(username,email,password);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(username);
        userResponse.setEmail(email);
        userResponse.setPassword(password);
        return userResponse;
    }

    @Override
    public Users updateUser(Users user, UUID id) {
        Optional<Users> users = userRepository.findById(id);
        users.get().setUsername(user.getUsername());
        users.get().setPassword(user.getPassword());
        users.get().setEmail_address(user.getEmail_address());

        return userRepository.save(users.get());
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
