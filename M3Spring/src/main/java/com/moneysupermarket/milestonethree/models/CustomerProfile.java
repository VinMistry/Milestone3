package com.moneysupermarket.milestonethree.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile {

  private Customer customer;

  private Address address;

  private Car car;

  @Override
  public String toString() {
    return "Customer Profile: \n" + customer.toString() + "\n" + address.toString() + "\n" + car.toString();
  }

}
