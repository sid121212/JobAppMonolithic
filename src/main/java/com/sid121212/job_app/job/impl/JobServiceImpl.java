package com.sid121212.job_app.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sid121212.job_app.job.Job;
import com.sid121212.job_app.job.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	private List<Job> jobs = new ArrayList<Job>();

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobs.add(job);
		
	}
	
}
