package com.moneysupermarket.milestonethree.models;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Time {

  private final LocalTime currentTime;
  private LocalTime canadaTime;


}
