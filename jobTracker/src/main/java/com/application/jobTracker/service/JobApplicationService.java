package com.application.jobTracker.service;

import com.application.jobTracker.JobTrackerApplication;
import com.application.jobTracker.dto.JobApplicationRequest;
import com.application.jobTracker.dto.JobApplicationResponse;
import com.application.jobTracker.model.JobApplication;
import com.application.jobTracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;
    public JobApplicationService(JobApplicationRepository repository){ this.repository=repository;}
    public JobApplicationResponse create (JobApplicationRequest request){
        JobApplication app=new JobApplication();
        app.setCompanyName(request.companyName());
        app.setJobTitle(request.jobTitle());
        app.setStatus(request.status());
        app.setAppliedDate(request.appliedDate());
        app.setNotes(request.notes());
        return toResponse(repository.save(app));

    }

    public JobApplicationResponse getById(Long id) {
        return toResponse(repository.findById(id).orElseThrow());
    }

    private JobApplicationResponse toResponse(JobApplication a) {
        return new JobApplicationResponse(a.getId(), a.getCompanyName(), a.getJobTitle(),
                a.getStatus(), a.getAppliedDate(), a.getNotes());
    }
}
