package com.red.ragconsultant.mapper;

import com.red.ragconsultant.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author red
 * @date 2025/11/11
 * @description
 */
@Mapper
public interface OrderMapper {
    // 添加订单
    @Insert("INSERT INTO order (username, email, game_name, payment_method, order_time) " +
            "VALUES (#{username}, #{email}, #{gameName}, #{paymentMethod}, #{orderTime})")
    void addOrder(Order order);
    // 根据用户名查询订单
    @Select("SELECT * FROM order WHERE username = #{username} ORDER BY order_time DESC")
    Order getOrderByUsername(String username);
}
