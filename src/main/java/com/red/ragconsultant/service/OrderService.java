package com.red.ragconsultant.service;

import com.red.ragconsultant.mapper.OrderMapper;
import com.red.ragconsultant.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author red
 * @date 2025/11/11
 * @description
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    // 添加订单
    public void addOrder(Order order){
        orderMapper.addOrder(order);
    }

    // 根据用户名查询订单
    public Order getOrderByUsername(String username){
        return orderMapper.getOrderByUsername(username);
    }
}
