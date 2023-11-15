/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unicauca.APIRestTravelAgencyServer.controller;

import co.unicauca.travelagency.commons.domain.Customer;
import edu.unicauca.APIRestTravelAgencyServer.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customService;
    /**
     * GET http://localhost:8080/customers
     * @return
     */
    @GetMapping
    public List<Customer> getCustomers(){
        return customService.getCustomers();
    }
    /**
     * GET http://localhost:8080/customers/1
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable String id){
        return customService.findCustomer(id);
    }
    /**
     * POST http://localhost:8080/customers
     * @param newCustomer
     * @return
     */
    @PostMapping
    public String createCustomer(@RequestBody Customer newCustomer){
        return customService.createCustomer(newCustomer);
    }
    /**
     * PUT http://localhost:8080/customers
     * @param customerMod
     * @return
     */
    @PutMapping
    public String updateUser(@RequestBody Customer customerMod){
        return customService.updateUser(customerMod);
    }
}
