package com.example.ecommerce;

import com.example.ecommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.ecommerce.exception.ResourceNotFoundException;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    public OrderService (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order with id " + id + " does not exist");
        }
        orderRepository.deleteById(id);
    }
    public Order getOrderById(Long id) {
      return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " does not exist"));

    }
    public Order updateOrder(Long id,Order order) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " does not exist"));
        existing.setUser(order.getUser());
        existing.setOrderStatus( order.getOrderStatus());
        existing.setTotalPrice( order.getTotalPrice());
        existing.setOrderDate(order.getOrderDate());
        return orderRepository.save(existing);


    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
