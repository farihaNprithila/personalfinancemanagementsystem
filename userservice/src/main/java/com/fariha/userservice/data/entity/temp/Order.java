package com.fariha.userservice.data.entity.temp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "order_details", nullable = false)
    private String orderDetails;

}
