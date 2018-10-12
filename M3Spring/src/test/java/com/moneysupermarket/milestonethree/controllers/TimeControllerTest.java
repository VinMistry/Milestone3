package com.moneysupermarket.milestonethree.controllers;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.moneysupermarket.milestonethree.services.TimeService;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(value = TimeController.class, secure = false)
class TimeControllerTest {


  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TimeService currentTimeService;

  @BeforeEach
  void setup() {

  }

  @Test
  public void test_getLocalTimes_success() throws Exception {
    final RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/current-time")
        .accept(MediaType.APPLICATION_JSON);

    final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse().getContentAsString());
    assertNotNull(result.getResponse());
    assertEquals(200, result.getResponse().getStatus());
    assertEquals("application/json;charset=UTF-8", result.getResponse().getContentType());
  }

  @Test
  public void test_getCanadianTimes_success() throws Exception {
    final RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/current-pdt-time")
        .accept(MediaType.APPLICATION_JSON);

    final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse().getContentAsString());
    assertNotNull(result.getResponse());
    assertEquals(200, result.getResponse().getStatus());
    assertEquals("application/json;charset=UTF-8", result.getResponse().getContentType());
  }

  @Test
  public void test_getAllTimes_success() throws Exception {
    final RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/all-current-times")
        .accept(MediaType.APPLICATION_JSON);

    final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse().getContentAsString());
    assertNotNull(result.getResponse());
    assertEquals(200, result.getResponse().getStatus());
    assertEquals("application/json;charset=UTF-8", result.getResponse().getContentType());
  }
  
}