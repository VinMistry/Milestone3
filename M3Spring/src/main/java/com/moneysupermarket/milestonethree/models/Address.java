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
public class Address {

  private String postcode;

  private String houseNumber;

  private String street;

  private String city;

  @Override
  public String toString() {
    return "Address: \n" +
        "postcode: " + postcode +
        ", \nhouseNumber: " + houseNumber +
        ", \nstreet: " + street +
        ", \ncity: " + city;
  }
}
