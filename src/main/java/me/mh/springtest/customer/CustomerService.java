package me.mh.springtest.customer;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public Long storeNewCustomer(Customer customer) throws DataIntegrityViolationException {
        Customer createdCustomer = customerRepository.save(customer);
        return createdCustomer.getId();
    }
}
