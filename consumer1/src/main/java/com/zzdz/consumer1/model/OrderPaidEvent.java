package com.zzdz.consumer1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Classname OrderPaidEvent
 * @Description TODO
 * @Date 2019/11/27 17:02
 * @Created by joe
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaidEvent implements Serializable {

    private String orderId;

    private BigDecimal paidMoney;
}
