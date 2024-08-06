package CompanyStore.io.order;

import CompanyStore.io.order.*;
//import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderNo}")
    public ResponseEntity<Order> getOrderById(@PathVariable int orderNo) {
        Optional<Order> order = orderService.getOrderById(orderNo);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{orderNo}")
    public ResponseEntity<Order> updateOrder(@PathVariable int orderNo, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(orderNo, orderDetails);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderNo}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderNo) {
        orderService.deleteOrder(orderNo);
        return ResponseEntity.noContent().build();
    }
}