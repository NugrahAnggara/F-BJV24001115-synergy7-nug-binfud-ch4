package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Order;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Data
@Setter
@Getter
public class OrderResponse {
    private UUID id;
    private Date order_time;
    private String destination_address;
    private UUID user_id;
    private boolean completed;
}
