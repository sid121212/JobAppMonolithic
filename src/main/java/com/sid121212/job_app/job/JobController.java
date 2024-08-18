package com.sid121212.job_app.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	
	private List<Job> jobs = new ArrayList<Job>();
	
	@GetMapping("/jobs")
	public List<Job> getAllJobs(){
		return jobs;
	}
	
	
	@PostMapping("/jobs")
	public String createJob(@RequestBody Job job) {
		jobs.add(job);
		return "Success! Job has been added";
	}	
}
