package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.LocomotiveSummary;
import com.example.repository.postgres.LocomotiveSummaryRepository;

@Service
public class SummaryService {

    @Autowired
    private LocomotiveSummaryRepository locomotiveSummaryRepository;

    public LocomotiveSummary getLocomotiveSummary() {
        return locomotiveSummaryRepository.findAll().get(0);
    }
}