package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue
    private UUID id;

    private int quantity;
    private double total_price;

    @OneToOne(mappedBy = "order_detail",cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @OneToOne()
    @JoinColumn(name = "id_product")
    private Product product;
}
