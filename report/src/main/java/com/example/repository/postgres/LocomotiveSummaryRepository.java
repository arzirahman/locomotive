package com.example.repository.postgres;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.LocomotiveSummary;

public interface LocomotiveSummaryRepository extends JpaRepository<LocomotiveSummary, UUID> {

}