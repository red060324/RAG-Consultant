package com.red.ragconsultant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author red
 * @date 2025/11/11
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String username;
    private String email;
    private String gameName;
    private String paymentMethod;
    private LocalDateTime orderTime;
}
