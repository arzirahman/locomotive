package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LocomotiveSummary;
import com.example.service.SummaryService;

@RestController
@RequestMapping("/api/summary")
@CrossOrigin
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @GetMapping("/summary")
    public ResponseEntity<LocomotiveSummary> geLocomotifSummary() {
        return ResponseEntity.ok(summaryService.getLocomotiveSummary());
    }
}