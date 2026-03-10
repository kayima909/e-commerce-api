package com.example.ecommerce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
    public class OrderController {
        private final OrderService orderService;
        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }
        @PostMapping
        public ResponseEntity<Order> createOrder(@RequestBody Order order){
            Order saved = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }
        @GetMapping("/{id}")
        public ResponseEntity<Order>getOrderById(@PathVariable Long id){
            Order order = orderService.getOrderById(id);
            return ResponseEntity.ok().body(order);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Order> updateOrder(@PathVariable Long id,@RequestBody Order order){
            Order updated = orderService.updateOrder(id , order);
            return ResponseEntity.ok().body(updated);
        }
        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long Id){
            orderService.deleteOrder(Id);
            return ResponseEntity.noContent().build();
        }
        @GetMapping
        public ResponseEntity<List<Order>> getAllOrders(){
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok().body(orders);
        }

}