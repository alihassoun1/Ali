package ali.com.controller;


import ali.com.dao.CustomerService;
import ali.com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/potservice/customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;


  //@Override
 // public CustomerService getService() {
    //return customerService;
 // }

  @PostMapping()
  public ResponseEntity<Customer>  addCustomer(@RequestBody Customer customer) {
    //return (ResponseEntity<Customer>)customer;
    customerService.addCustomer(customer);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @GetMapping(path = "/{customerId}")
  public ResponseEntity<Customer>  getCustomer(@PathVariable("customerId") Integer customerId) {
    //return (ResponseEntity<Customer>)super.get(customerId);
    Customer customer=customerService.getCustomer(customerId);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @GetMapping(path="/getAll")
  public ResponseEntity<List<Customer>>  getAllCustomers()

  {
    //return (ResponseEntity<List<Customer>>)super.getAll();

    List<Customer> customers=(List<Customer>) customerService.getAll();
    return new ResponseEntity<>(customers, HttpStatus.OK);

  }

  @GetMapping(path="/getAllSorted")
  public @ResponseBody List<Customer> getAllCustomersSorted() {
    return (List<Customer>) customerService.getAllSorted();
  }


  @PutMapping(path = "/{customerId}")
  public ResponseEntity<Customer>  updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer){
   // return (ResponseEntity<Customer>) super.update(customer,customerId);
    customerService.updateCustomer(customerId,customer);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{customerId}")
  public ResponseEntity<Customer>  deleteCustomer (@PathVariable("customerId") Integer customerId) {
    //return (ResponseEntity<Customer>)super.delete(customerId);
    Customer customer=customerService.getCustomer(customerId);
    customerService.deleteCustomer(customerId);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }


}
