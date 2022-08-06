package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orderList = new ArrayList<>();

    public OrderService() {
        List<Meal> mealList1 = new ArrayList<>();
        mealList1.add(new Meal("hamburger", 2500, "good"));
        mealList1.add(new Meal("hamburger", 2300, "good"));
        List<Meal> mealList2 = new ArrayList<>();
        mealList2.add(new Meal("hamburger", 1000, "good"));
        this.orderList.add(new Order(1, 1000, "david", mealList1));
        this.orderList.add(new Order(2, 2000, "david", mealList2));
    }

    public List<Order> getAllOrders() {
        return this.orderList;
    }

    public Order getOrder(int id) {
        for (Order order : this.orderList) {
            if (id == order.getSeq()) {
                return order;
            }
        }
        return null;
    }

    public Order creatOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder(int seq, Order order) {
        for (Order updateOrder : this.orderList) {
            if (seq == updateOrder.getSeq()) {
                updateOrder.setWaiter(order.getWaiter());
                updateOrder.setMealList(order.getmealList());
                return updateOrder;
            }
        }
        return null;
    }

    public Order deleteOrder(int id) {
        for (Order order : this.orderList) {
            if (id == order.getSeq()) {
                this.orderList.remove(order);
                return order;
            }
        }
        return null;
    }
}

