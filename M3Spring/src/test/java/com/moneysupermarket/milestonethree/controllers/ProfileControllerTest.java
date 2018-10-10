package com.moneysupermarket.milestonethree.controllers;


import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.moneysupermarket.milestonethree.models.CustomerProfile;
import com.moneysupermarket.milestonethree.repositories.CustomerProfileRepository;
import com.moneysupermarket.milestonethree.services.CustomerProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
class ProfileControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private ProfileController controllerToTest;

  @Mock
  CustomerProfile customerProfile;
  @MockBean
  CustomerProfileRepository customerProfileRepository;

  @MockBean
  CustomerProfileService customerProfileService;

  @Mock
  List<CustomerProfile> customerProfiles;

  @Mock
  ResponseEntity<List> responseEntity;

  @BeforeEach
  void setUp() {
    controllerToTest = new ProfileController(customerProfileService);

  }

  @Test
  void save() {

  }

  @Test
  void allCustomerProfilesMethodTestUsingMockito() {
    controllerToTest.getAllCustomerProfiles();
    verify(customerProfileService).getAllProfiles();
  }

  @Test
  public void saveProfile_IsValid_ProfilePersisted_Test() throws Exception {
    final String personDTOJson = "{\n"
        + "    \"customer\": {\n"
        + "        \"firstName\": \"Dan\",\n"
        + "        \"lastName\": \"Graef\"\n"
        + "    },\n"
        + "    \"address\": {\n"
        + "        \"postcode\": \"M24 223\",\n"
        + "        \"houseNumber\": \"31\",\n"
        + "        \"street\": \"Street\",\n"
        + "        \"city\": \"Manch\"\n"
        + "    },\n"
        + "    \"car\": {\n"
        + "        \"registration\": \"CFM 139W\",\n"
        + "        \"make\": \"BMW\",\n"
        + "        \"model\": \"M4\",\n"
        + "        \"engineSize\": \"1\"\n"
        + "    }\n"
        + "}";
    mockMvc.perform(post("/customerProfile").content(personDTOJson).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    verify(customerProfileService).save(any(CustomerProfile.class));
  }

  @Test
  public void saveProfile_invalidSyntax_Test() throws Exception {
    final String personDTOJson = "";
    mockMvc.perform(post("/customerProfile").content(personDTOJson).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().is(400));
    verify(customerProfileService, times(0)).save(any(CustomerProfile.class));
  }


  @Test
  void tests() throws Exception {
    mockMvc.perform(get("/getAllProfiles")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void getAllCustomerProfiles_returns_response_entity_with_customer_list_test() throws Exception {
    final RequestBuilder requestBuilder = get("/getAllProfiles")
        .accept(MediaType.APPLICATION_JSON);

    final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse().getContentAsString());
    assertNotNull(result.getResponse());
    assertEquals(200, result.getResponse().getStatus());
    assertEquals("application/json;charset=UTF-8", result.getResponse().getContentType());
  }

  @Test
  void getCustomerProfileWithId_successfullyReturns_responseEntity_test() throws Exception {
    final String personDTOJson = "5bbc6b19200d487a5aac32b7";
    mockMvc.perform(get("/getProfile/" + personDTOJson).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().is(200));
    verify(customerProfileService).getProfileById("5bbc6b19200d487a5aac32b7");
  }

  @Test
  void getCustomerProfileWithId_invalidProfileId_responseEntity_test() throws Exception {
    Assertions
        .assertEquals(404, new ProfileController(new CustomerProfileService(customerProfileRepository)).getCustomerProfile("bskbv").getStatusCode().value());
  }
}