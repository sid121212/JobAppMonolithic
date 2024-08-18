package com.sid121212.job_app.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("Server Running");
	}
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getAllJobs(){
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@GetMapping("jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job = jobService.findJobById(id);
		if (job!=null) {
			return new ResponseEntity<> (job,HttpStatus.OK);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<> ("Job with id: "+job.getId()+"has been succesfully created",HttpStatus.OK);
	}	
}
