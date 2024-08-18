package com.sid121212.job_app.job;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid121212.job_app.job.impl.JobServiceImpl;

@RestController
public class JobController {
	
	private JobService jobService;
	
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/health")
	public String healthCheck() {
		return "Server Running";
	}
	
	@GetMapping("/jobs")
	public List<Job> getAllJobs(){
		return jobService.findAll();
	}
	
	
	@PostMapping("/jobs")
	public String createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return "Job with id: "+job.getId()+"has been succesfully created";
	}	
}
