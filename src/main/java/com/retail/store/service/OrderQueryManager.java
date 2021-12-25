package com.retail.store.service;

import com.retail.store.model.dto.OrderDTO;
import com.retail.store.model.entity.Order;
import com.retail.store.model.enu.PersonType;
import com.retail.store.model.response.ResponseMessage;
import com.retail.store.repostiory.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderQueryManager extends AbstractQueryManager<Order, OrderDTO> {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderQueryManager(ModelMapper modelMapper, OrderRepository orderRepository) {
        super(orderRepository, modelMapper);
        this.orderRepository = orderRepository;

    }

    @Override
    public ResponseMessage addData(OrderDTO orderDTO) {

        Order order = null;
        double dis = calculateDiscount(orderDTO);
        try {
            order = super.dtoToEntity(orderDTO);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"something went wrong");
        }
        order.setTotalPrice(order.getTotalPrice() - dis);
        orderRepository.save(order);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Created");

        return responseMessage;

    }

    private double calculateDiscount(OrderDTO orderDTO) {
        double discount = 0;
        if (PersonType.EMPLOYEE.equals(orderDTO.getPersonType())) {


            return  orderDTO.getTotalPrice() * 30 / 100;
        }
        if (PersonType.CUSTOMER.equals(orderDTO.getPersonType())) {
            return  orderDTO.getTotalPrice() * 10 / 100;

        }
        if (orderDTO.getTotalPrice() >= 100) {
            Math.acos(49.9);
            return  orderDTO.getTotalPrice() * 5 / 100;
        }
        return discount;
    }
}
