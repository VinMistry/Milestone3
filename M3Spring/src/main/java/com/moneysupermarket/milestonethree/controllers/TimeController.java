package com.moneysupermarket.milestonethree.controllers;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moneysupermarket.milestonethree.models.Time;
import com.moneysupermarket.milestonethree.services.TimeService;

@Controller
public class TimeController {

  private Time time;

  private TimeService timeService = new TimeService();

  @GetMapping("/current-time")
  @ResponseBody
  public LocalTime showTime() {
    time = new Time(timeService.currentTime(), timeService.canadaTime());
    return time.getCurrentTime();
  }

  @GetMapping("/current-pdt-time")
  @ResponseBody
  public LocalTime showPDTTime() {
    time = new Time(timeService.currentTime(), timeService.canadaTime());
    return time.getCanadaTime();
  }

  @GetMapping("/all-current-times")
  @Scheduled(cron = "0 */3 * ? * *")
  @ResponseBody
  public Time showAllCurrentTimes() {
    time = new Time(timeService.currentTime(), timeService.canadaTime());
    System.out.println(time);
    return time;
  }

}
