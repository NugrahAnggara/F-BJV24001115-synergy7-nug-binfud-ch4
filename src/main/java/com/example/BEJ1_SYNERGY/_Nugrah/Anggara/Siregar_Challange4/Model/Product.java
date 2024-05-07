package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "product")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String product_name;
    private double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_merchant")
    private Merchant merchant;
}
