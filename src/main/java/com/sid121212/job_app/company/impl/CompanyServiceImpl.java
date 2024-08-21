package com.sid121212.job_app.company.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sid121212.job_app.company.Company;
import com.sid121212.job_app.company.CompanyRepository;
import com.sid121212.job_app.company.CompanyService;
import com.sid121212.job_app.job.Job;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepo;
	

	public CompanyServiceImpl(CompanyRepository companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
		
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepo.findById(id).orElse(null);
	}

	@Override
	public void addCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepo.save(company);
		
	}

	@Override
	public boolean updateCompany(Company company, Long id) {
		Company temp = companyRepo.findById(id).orElse(null);
		if (temp==null) {
			return false;
		}
        temp.setDescription(company.getDescription());
        temp.setName(company.getName());
        temp.setJobs(company.getJobs());
        companyRepo.save(temp);
        return true;
		
	}

	@Override
	public boolean deleteCompany(Long id) {
		// TODO Auto-generated method stub
		if (companyRepo.existsById(id)) {
            companyRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
	}

}
