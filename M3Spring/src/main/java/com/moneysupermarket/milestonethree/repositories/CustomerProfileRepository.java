package com.moneysupermarket.milestonethree.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moneysupermarket.milestonethree.models.CustomerProfile;

public interface CustomerProfileRepository extends MongoRepository<CustomerProfile, String> {

}
