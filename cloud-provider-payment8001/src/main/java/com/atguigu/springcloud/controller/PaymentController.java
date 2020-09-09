package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xujian
 * @date 2020-09-09 23:39
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
       int result = paymentService.create(payment);
       if(result > 0){
           return new CommonResult(200,"插入成功",payment);
       }else {
           return new CommonResult(200,"插入失败");
       }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询下成功",payment);
        }else {
            return new CommonResult(200,"未找到该记录");
        }
    }
}
