package CompanyStore.io.order;

import CompanyStore.io.order.*;
//import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
      return customerService.getAllCustomers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
      Optional<Customer> customer = customerService.getCustomerById(id);
      return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
      Customer createdCustomer = customerService.createCustomer(customer);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
      Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
      return ResponseEntity.ok(updatedCustomer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
      customerService.deleteCustomer(id);
      return ResponseEntity.noContent().build();
  }
}