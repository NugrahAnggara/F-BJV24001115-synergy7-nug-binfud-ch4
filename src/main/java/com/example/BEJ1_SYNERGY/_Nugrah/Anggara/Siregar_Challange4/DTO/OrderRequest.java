package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OrderRequest {
    private String idUser;
    private String address;
    private String idProduct;
    private int quantity;
}
