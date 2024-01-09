package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "locomotif")
public class Locomotive {
    @Id
    private String locoCode;
    private String locoName;
    private String locoDimension;
    private String status;
    private String time;
}