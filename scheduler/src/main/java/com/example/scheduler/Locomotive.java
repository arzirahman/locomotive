package com.example.scheduler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Locomotive {
    private String locoCode;
    private String locoName;
    private String locoDimension;
    private String status;
    private String time;
}
