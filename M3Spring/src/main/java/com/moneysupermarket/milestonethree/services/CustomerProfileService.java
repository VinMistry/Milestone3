package com.moneysupermarket.milestonethree.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.moneysupermarket.milestonethree.models.CustomerProfile;
import com.moneysupermarket.milestonethree.repositories.CustomerProfileRepository;
import com.moneysupermarket.milestonethree.responses.CustomerProfileResponse;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomerProfileService {

  private CustomerProfileRepository customerProfileRepository;

  public ResponseEntity<List> getAllProfiles() {
    final List<CustomerProfile> customerProfile = customerProfileRepository.findAll();
    if (!customerProfile.isEmpty()) {
      customerProfile.forEach(customer -> System.out.println(customer));
      return new ResponseEntity<>(customerProfile, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<CustomerProfileResponse> save(final CustomerProfile customerProfile) {
    customerProfileRepository.save(customerProfile);
    System.out.println(customerProfile);
    return new ResponseEntity<>(CustomerProfileResponse.builder().customerProfileID(UUID.randomUUID().toString()).build(), HttpStatus.OK);
  }

  public ResponseEntity<CustomerProfile> getProfileById(final String profileID) {
    final Optional<CustomerProfile> customerProfile = customerProfileRepository.findById(profileID);
    if (customerProfile.isPresent()) {
      System.out.println(customerProfile.get());
      return new ResponseEntity<>(customerProfile.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
