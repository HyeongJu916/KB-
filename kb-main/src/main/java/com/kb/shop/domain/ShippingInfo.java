package com.kb.shop.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Order id
    private int order_id;

    // OrderItem id
    private int orderItems_id;

    // shippingStatus
    private String status;

}


