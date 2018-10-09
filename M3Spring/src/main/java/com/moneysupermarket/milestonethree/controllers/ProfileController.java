package com.moneysupermarket.milestonethree.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moneysupermarket.milestonethree.models.CustomerProfile;
import com.moneysupermarket.milestonethree.models.CustomerProfileResponse;
import com.moneysupermarket.milestonethree.repositories.CustomerProfileRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProfileController {

  private CustomerProfileRepository customerProfileRepository;

  @PostMapping(value = "people")
  public ResponseEntity<CustomerProfileResponse> save(@RequestBody final CustomerProfile customerProfile) {
    customerProfileRepository.save(customerProfile);
    System.out.println(customerProfile);
    return new ResponseEntity<>(CustomerProfileResponse.builder().customerProfileID(UUID.randomUUID().toString()).build(), HttpStatus.OK);
  }

  @GetMapping("/getProfile/{profileID}")
  public @ResponseBody
  CustomerProfile getCustomerProfile(@PathVariable final String profileID) {
    final Optional<CustomerProfile> customerProfile = customerProfileRepository.findById(profileID);
    if (customerProfile.isPresent()) {
      System.out.println(customerProfile.get());
      return customerProfile.get();
    }
    return null;
  }
}
