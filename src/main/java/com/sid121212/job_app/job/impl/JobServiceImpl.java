package com.sid121212.job_app.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sid121212.job_app.job.Job;
import com.sid121212.job_app.job.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	private List<Job> jobs = new ArrayList<Job>();
	private Long id = (long) 0;
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		job.setId(++id);
		jobs.add(job);
		
	}

	@Override
	public Job findJobById(Long jobId) {
		for (Job job : jobs) {
            if (job.getId().equals(jobId)) {
                return job;
            }
        }
		return null;
	}

	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		boolean jobExists = jobs.removeIf(job -> job.getId().equals(id));
	    return jobExists;
		
	}

	@Override
	public boolean updateJob(Job job, Long id) {
		// TODO Auto-generated method stub
		for (Job temp : jobs) {
            if (temp.getId().equals(id)) {
                temp.setDescription(job.getDescription());
                temp.setLocation(job.getLocation());
                temp.setMaxSalary(job.getMaxSalary());
                temp.setMinSalary(job.getMinSalary());
                temp.setTitle(job.getTitle());
                return true;
            }
        }
		return false;
		
	}
	
}
