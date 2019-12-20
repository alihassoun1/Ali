package ali.com.dao;



import ali.com.model.Customer;
import ali.com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class CustomerService  {

    @Autowired
    CustomerRepository customerRepository;


    public Customer addCustomer(Customer customer) {

        customerRepository.save(customer);
        return customer;
    }

    public Customer getCustomer(Integer customerId)
    {
        //Optional<Customer> customer=customerRepository.findById(customerId);
        //return customer.get();
        return customerRepository.findById(customerId).get();

    }

    public Iterable<Customer> getAll() { return customerRepository.findAll(); }

    public Iterable<Customer> getAllSorted() { return customerRepository.findAll(Sort.by("customerName")); }

    public Customer updateCustomer(Integer customerId,Customer newCustomer){

        Customer oldCustomer =customerRepository.findById(customerId).get();
            oldCustomer.setCustomerName(newCustomer.getCustomerName());
            oldCustomer.setProjects(newCustomer.getProjects());
            customerRepository.save(oldCustomer);
            return newCustomer;
    }

    public void deleteCustomer(Integer customerId) {

        customerRepository.deleteById(customerId); }

    //public CustomerRepository getRepository() {
        //return customerRepository;
   // }
}
