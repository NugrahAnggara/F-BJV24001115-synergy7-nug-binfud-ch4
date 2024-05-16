package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Dto.OrderResponseDto;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.OrderDetail;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.User;

import java.text.ParseException;
import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(User user, Product product, String address, int quantity) throws ParseException;

    List<OrderDetail> getOrderDetail(String id);
}
