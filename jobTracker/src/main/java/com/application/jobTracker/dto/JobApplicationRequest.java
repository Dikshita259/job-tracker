package com.application.jobTracker.dto;

import com.application.jobTracker.model.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record JobApplicationRequest(
    @NotBlank String companyName,
    @NotBlank String jobTitle,
    @NotNull ApplicationStatus status,
    @NotNull @PastOrPresent LocalDate appliedDate,
    String notes) {}



