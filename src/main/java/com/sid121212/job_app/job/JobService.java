package com.sid121212.job_app.job;

import java.util.List;

public interface JobService {
	
	List<Job> findAll();
	void createJob(Job job);
	

}