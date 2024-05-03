package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Controller;


import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.DTO.OrderRequest;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Order;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.OrderDetail;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Users;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.ProductRepository;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.UserRepository;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Order addOrder(@ModelAttribute OrderRequest orderRequest) throws ParseException {

        Optional<Users> user = userRepository.findById(UUID.fromString(orderRequest.getIdUser()));
        Optional<Product> product = productRepository.findById(UUID.fromString(orderRequest.getIdProduct()));

        return orderService.createOrder(user.get(),product.get(),orderRequest.getAddress(),orderRequest.getQuantity());
    }


    @GetMapping(path = "/detail/{id}")
    List<OrderDetail> getOrder(@PathVariable String id){
        return orderService.getOrderDetail(id);
    }


}
