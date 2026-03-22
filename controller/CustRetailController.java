package com.example.springbootdemo.controller;



import com.example.springbootdemo.service.CustRetailServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustRetailController {

private CustRetailServices custRetailServices;

    public  CustRetailController(CustRetailServices custRetailServices){
        this.custRetailServices = custRetailServices;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Map<String, Object>> getCustomerRewards(@PathVariable ("customerId")Integer cusId) {
        Map<String, Object> rewards = custRetailServices.getCustomerRewards(cusId);
        return ResponseEntity.ok(rewards);
    }

}
