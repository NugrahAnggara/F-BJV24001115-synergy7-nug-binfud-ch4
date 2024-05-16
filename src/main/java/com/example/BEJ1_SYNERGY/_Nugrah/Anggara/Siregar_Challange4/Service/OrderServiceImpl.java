package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Dto.OrderResponseDto;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Order;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.OrderDetail;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.User;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.OrderDetailRepository;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderResponseDto createOrder(User user, Product product, String address, int quantity) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Order dataOrder = new Order();
        dataOrder.setUser(user);
        dataOrder.setOrder_time(sdf.parse(LocalDate.now().toString()));
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
        Order data = orderRepository.save(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(data.getId());
        orderResponseDto.setOrder_time(data.getOrder_time());
        orderResponseDto.setDestination_address(data.getDestination_address());
        orderResponseDto.setUser_id(data.getUser().getId());
        orderResponseDto.setCompleted(data.isCompleted());
        return orderResponseDto;
    }

    @Override
    public List<OrderDetail> getOrderDetail(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<List<OrderDetail>> orderDetail = Optional.ofNullable(orderDetailRepository.findByOrder(uuid));
        if (orderDetail.isEmpty()){
            return null;
        }

        return orderDetail.get();
    }
}
