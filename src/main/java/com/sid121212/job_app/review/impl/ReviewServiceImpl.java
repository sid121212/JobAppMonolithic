package com.sid121212.job_app.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sid121212.job_app.company.Company;
import com.sid121212.job_app.company.CompanyService;
import com.sid121212.job_app.review.Review;
import com.sid121212.job_app.review.ReviewRepository;
import com.sid121212.job_app.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewRepository reviewRepo;
	private CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewRepo,CompanyService companyService) {
		super();
		this.reviewRepo = reviewRepo;
		this.companyService = companyService;
	}

	@Override
	public List<Review> findAll(Long companyId) {
		return reviewRepo.findByCompanyId(companyId);
		
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompanyById(companyId);
		if (company != null) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		}
		return false;
		
	}

	@Override
	public Review getReviewById(Long reviewId) {
		Review temp = reviewRepo.findById(reviewId).orElse(null);
		return temp;
	}

	@Override
	public boolean updateById(Long reviewId,Review review) {
		Review temp = reviewRepo.findById(reviewId).orElse(null);
		if (temp!=null) {
			temp.setDescription(review.getDescription());
			temp.setRating(review.getRating());
			temp.setTitle(review.getTitle());
			reviewRepo.save(temp);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteById(Long reviewId) {
		try{
			reviewRepo.deleteById(reviewId); 
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

}
