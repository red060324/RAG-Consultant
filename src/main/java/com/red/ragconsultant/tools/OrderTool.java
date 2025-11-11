package com.red.ragconsultant.tools;

import com.red.ragconsultant.pojo.GameOrder;
import com.red.ragconsultant.service.OrderService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author red
 * @date 2025/11/11
 * @description
 */
@Component
public class OrderTool {
    @Autowired
    private OrderService orderService;
    // 添加订单的工具方法
    @Tool("购买游戏添加订单服务")
    public void addOrderTool(
            @P("用户名") String username,
            @P("用户邮箱") String email,
            @P("游戏名称") String gameName,
            @P("支付方式") String paymentMethod,
            @P("下单时间，格式为：yyyy-MM-dd'T'HH:mm") String orderTime

    ){
        GameOrder gameOrder = new GameOrder(null, username, email, gameName, paymentMethod, LocalDateTime.parse(orderTime));
        orderService.addOrder(gameOrder);
    }

    // 根据用户名查询订单的工具方法
    @Tool("根据用户名查询订单服务")
    public GameOrder getOrderByUsernameTool(@P("用户名") String username) {
        return orderService.getOrderByUsername(username);
    }
}
