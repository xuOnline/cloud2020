package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author xujian
 * @date 2020-09-09 23:35
 */
@Service
public interface PaymentService {


    int create(Payment payment);

    Payment getPaymentById(Long id);
}
