package me.mh.springtest.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createNewCustomer(@RequestBody @Validated Customer customer
            , UriComponentsBuilder uriComponentsBuilder) {
        try {
            Long userId = this.customerService.storeNewCustomer(customer);
            if (userId > 0) {
                return ResponseEntity
                        .created(uriComponentsBuilder.path("/api/customers/{id}").build(userId))
                        .build();
            }
        } catch (DataIntegrityViolationException dive) {
            logger.error(dive.getMessage());
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
