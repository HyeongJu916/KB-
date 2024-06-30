package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo selectSippingInfo(Long id) {
        String sql = "SELECT * FROM ShippingInfo WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        String sql = "INSERT INTO ShippingInfo (order_id, orderItems_id, status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, shippingInfo.getOrder_id(), shippingInfo.getOrderItems_id(), shippingInfo.getStatus());
    }

    public ShippingInfo selectSippingInfoByOrderId (int order_id) {
        String sql = "SELECT * FROM ShippingInfo WHERE order_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{order_id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void updateShippingInfo(ShippingInfo shippingInfo){
        String sql = "UPDATE ShippingInfo set status = ? WHERE id = ?";
        jdbcTemplate.update(sql, shippingInfo.getStatus(), shippingInfo.getId());
    }

}


