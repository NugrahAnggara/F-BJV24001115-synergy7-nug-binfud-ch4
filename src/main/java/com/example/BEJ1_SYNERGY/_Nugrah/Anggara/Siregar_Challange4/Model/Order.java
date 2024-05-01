package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Temporal(value = TemporalType.DATE)
    private Date order_time;
    private String destination_address;
    private boolean completed;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "id_users")
    private Users user;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order_detail")
    private OrderDetail order_detail;
}
