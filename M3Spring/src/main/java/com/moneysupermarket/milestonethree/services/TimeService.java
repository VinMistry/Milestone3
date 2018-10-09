package com.moneysupermarket.milestonethree.services;

import java.time.LocalTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

@Component
public class TimeService {

  public static LocalTime currentTime() {
    return LocalTime.now();
  }

  public static LocalTime canadaTime() {
    return LocalTime.now(ZoneId.of("UTC-7"));
  }

}
