package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    @Modifying
    @Query(value = "CALL createUser(:username, :email_address, :passwords)", nativeQuery = true)
    void registrationUser(@Param("username") String username,
                          @Param("email_address") String email,
                          @Param("passwords") String password);

    @Query(value = "select * from users where users.username = :username",nativeQuery = true)
    Users findByUsername(@Param("username") String username);
}
