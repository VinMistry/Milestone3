package com.moneysupermarket.milestonethree.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moneysupermarket.milestonethree.models.CustomerProfile;
import com.moneysupermarket.milestonethree.responses.CustomerProfileResponse;
import com.moneysupermarket.milestonethree.services.CustomerProfileService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProfileController {

  CustomerProfileService customerProfileService;

  @PostMapping(value = "customerProfile")
  public ResponseEntity<CustomerProfileResponse> save(@RequestBody final CustomerProfile customerProfile) {
    return customerProfileService.save(customerProfile);
  }

  @GetMapping("/getAllProfiles")
  public ResponseEntity<List> getAllCustomerProfiles() {
    return customerProfileService.getAllProfiles();
  }

  @GetMapping("/getProfile/{profileID}")
  public @ResponseBody
  ResponseEntity<CustomerProfile> getCustomerProfile(@PathVariable final String profileID) {
    return customerProfileService.getProfileById(profileID);
  }
}
