package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String product_name;
    private double price;

    @ManyToOne(targetEntity = Merchant.class)
    @JoinColumn(name = "id_merchant")
    private Merchant merchant;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order_detail")
    private OrderDetail orderDetail;
}
