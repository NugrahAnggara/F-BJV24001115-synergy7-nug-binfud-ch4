package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO.OrderResponse;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Order;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.OrderDetail;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;

import java.text.ParseException;
import java.util.List;

public interface OrderService {
    OrderResponse createOrder(Users user, Product product, String address, int quantity) throws ParseException;

    List<OrderDetail> getOrderDetail(String id);
}
