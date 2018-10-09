package com.moneysupermarket.milestonethree.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Customer {

  private String firstName;

  private String lastName;


  @Override
  public String toString() {
    return "Customer: \n" +
        " firstName: " + firstName +
        ",\n lastName: " + lastName;
  }
}
