package com.example.springrestfulpractice.controller;


import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> orderList = this.orderService.getAllOrders();
        return orderList;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = this.orderService.getOrder(id);
        return order;
    }

    @PostMapping()
    public Order creatOrder(@RequestBody Order order) {
        Order createdOrder = this.orderService.creatOrder(order);
        return createdOrder;
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
        Order updateOrder = this.orderService.updateOrder(id, order);
        return updateOrder;
    }

    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable int id) {
        Order deleteOrder = this.orderService.deleteOrder(id);
        return deleteOrder;
    }


}

