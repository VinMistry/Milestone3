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
public class Car {

  private String registration;

  private String make;

  private String model;

  private String engineSize;


  @Override
  public String toString() {
    return "Car: \n" +
        " registration: " + registration +
        ",\n make: " + make +
        ",\n model: " + model +
        ",\n engineSize: " + engineSize;
  }
}
