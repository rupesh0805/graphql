package com.project.graphql.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderDetail;
    private String address;
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
