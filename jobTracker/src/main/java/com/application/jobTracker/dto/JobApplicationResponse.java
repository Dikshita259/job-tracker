package com.application.jobTracker.dto;

import com.application.jobTracker.model.ApplicationStatus;

import java.time.LocalDate;

public record JobApplicationResponse(
        Long id, String companyName, String jobTitle,
        ApplicationStatus status, LocalDate appliedDate, String notes) {}
