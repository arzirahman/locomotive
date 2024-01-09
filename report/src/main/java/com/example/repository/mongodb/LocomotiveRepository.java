package com.example.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Locomotive;

public interface LocomotiveRepository extends MongoRepository<Locomotive, String> {
    long countByStatus(String status);
}
