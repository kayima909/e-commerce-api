package com.example.ecommerce;

import com.example.ecommerce.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.ecommerce.exception.ResourceNotFoundException;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    public void deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new ResourceNotFoundException( "Order Item Not Found");
        }
        orderItemRepository.deleteById(id);
    }
    public OrderItem getOrderItem(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException( "Order Item Not Found"));
    }
    public OrderItem updateOrderItem( Long id,OrderItem orderItem) {
        OrderItem existing = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException( "Order Item with id " + id+ "Not Found"));
        existing.setQuantity(orderItem.getQuantity());
        existing.setOrderPrice(orderItem.getOrderPrice());
        existing.setProduct(orderItem.getProduct());
        existing.setOrder(orderItem.getOrder());
        return orderItemRepository.save(existing);

    }
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
}
