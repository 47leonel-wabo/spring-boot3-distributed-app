package com.wbt.customer.customer;

import com.wbt.customer.customer.dto.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = {"/api/v1/customers"})
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void register(final @RequestBody CustomerRegistrationRequest registrationRequest) {
        log.info("Request for registration with {}", registrationRequest);
        customerService.register(registrationRequest);
    }

}
