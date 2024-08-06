package CompanyStore.io.order;

import CompanyStore.io.order.*;
//import CompanyStore.io.order.repository.OrderRepository;
//import CompanyStore.io.order.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CustomerRepository customerRepository;

  public List<Order> getAllOrders() {
      return orderRepository.findAll();
  }

  public Optional<Order> getOrderById(int orderNo) {
      return orderRepository.findById(orderNo);
  }

  public Order createOrder(Order order) {
      return orderRepository.save(order);
  }

  public Order updateOrder(int orderNo, Order orderDetails) {
      Order order = orderRepository.findById(orderNo)
              .orElseThrow(() -> new RuntimeException("Order not found with id " + orderNo));

      order.setSku(orderDetails.getSku());
      order.setShipped_qty(orderDetails.getShipped_qty());
      order.setStatus(orderDetails.getStatus());
      order.setShip_date(orderDetails.getShip_date());
      order.setDelivered_date(orderDetails.getDelivered_date());
      order.setTransporter(orderDetails.getTransporter());
      order.setTransporter_code(orderDetails.getTransporter_code());
      order.setChannel(orderDetails.getChannel());
      order.setCustomer(orderDetails.getCustomer());

      return orderRepository.save(order);
  }

  public void deleteOrder(int orderNo) {
      orderRepository.deleteById(orderNo);
  }
}

