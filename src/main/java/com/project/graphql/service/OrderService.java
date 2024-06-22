package com.project.graphql.service;

import com.project.graphql.entities.Order;
import com.project.graphql.helper.ExceptionHelper;
import com.project.graphql.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    //create Order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    //get All Order
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    //get single order
    public Order getOrder(int orderId){
        return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    //delete Order
    public boolean deleteOrder(int orderId){
        Order order = getOrder(orderId);
        orderRepo.delete(order);
        return true;
    }
}
