package com.sid121212.job_app.review;

import java.util.List;


public interface ReviewService {
	List<Review> findAll(Long companyId);
	boolean addReview(Long companyId,Review review);
	Review getReviewById(Long reviewId);
	boolean updateById(Long reviewId, Review review);
	boolean deleteById(Long reviewId);
}
