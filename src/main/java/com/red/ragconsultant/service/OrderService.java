package com.red.ragconsultant.service;

import com.red.ragconsultant.mapper.OrderMapper;
import com.red.ragconsultant.pojo.GameOrder;
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
    public void addOrder(GameOrder gameOrder){
        orderMapper.addOrder(gameOrder);
    }

    // 根据用户名查询订单
    public GameOrder getOrderByUsername(String username){
        return orderMapper.getOrderByUsername(username);
    }
}
