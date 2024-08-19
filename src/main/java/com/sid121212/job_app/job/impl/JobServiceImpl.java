package com.sid121212.job_app.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sid121212.job_app.job.Job;
import com.sid121212.job_app.job.JobRepository;
import com.sid121212.job_app.job.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	// private List<Job> jobs = new ArrayList<Job>();
	private JobRepository jobRepo;
	public JobServiceImpl(JobRepository jobRepo) {
		super();
		this.jobRepo = jobRepo;
	}

	
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		
		jobRepo.save(job);
		
	}

	@Override
	public Job findJobById(Long jobId) {
		return jobRepo.findById(jobId).orElse(null);
	}

	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		try {
			jobRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	    
		
	}

	@Override
	public boolean updateJob(Job job, Long id) {
		// TODO Auto-generated method stub
		Job temp = jobRepo.findById(id).orElse(null);
		if (temp==null) {
			return false;
		}
        temp.setDescription(job.getDescription());
        temp.setLocation(job.getLocation());
        temp.setMaxSalary(job.getMaxSalary());
        temp.setMinSalary(job.getMinSalary());
        temp.setTitle(job.getTitle());
        jobRepo.save(temp);
        return true;
		
	}
	
}
