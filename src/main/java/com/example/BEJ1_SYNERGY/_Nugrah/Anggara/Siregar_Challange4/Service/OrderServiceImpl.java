package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Order;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.OrderDetail;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.OrderDetailRepository;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public Order createOrder(Users user, Product product, String address, int quantity) {
        Order dataOrder = new Order();
        dataOrder.setUser(user);
        dataOrder.setDestination_address(address);
        dataOrder.setCompleted(false);
        Order order = orderRepository.save(dataOrder);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        orderDetail.setQuantity(quantity);
        orderDetail.setTotal_price(quantity * product.getPrice());

        orderDetailRepository.save(orderDetail);
        order.setCompleted(true);
        return orderRepository.save(order);
    }
}