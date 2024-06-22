package com.project.graphql.controller;

import com.project.graphql.entities.Order;
import com.project.graphql.service.OrderService;
import com.project.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;
    private UserService userService;

    public OrderController(OrderService orderService, UserService userService){
        this.userService = userService;
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId){
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(userService.getUser(userId));
        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrder();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
}
