package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xujian
 * @date 2020-09-09 23:39
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
       int result = paymentService.create(payment);
       if(result > 0){
           return new CommonResult(200,"插入成功,serverPort: " + serverPort,payment);
       }else {
           return new CommonResult(200,"插入失败,serverPort: " + serverPort);
       }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询下成功,serverPort: " + serverPort,payment);
        }else {
            return new CommonResult(200,"未找到该记录,serverPort: " + serverPort);
        }
    }
}
