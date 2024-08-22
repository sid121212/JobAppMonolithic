package com.sid121212.job_app.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
	
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}
	
	@GetMapping("/review")
	public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
		return new ResponseEntity<>(reviewService.findAll(companyId),HttpStatus.OK);
	}
	
	@PostMapping("/review")
	public ResponseEntity<String> createReview(@PathVariable Long companyId,@RequestBody Review review) {
		if (reviewService.addReview(companyId,review))
			return new ResponseEntity<> ("Review with id: "+review.getId()+" has been succesfully created",HttpStatus.CREATED);
		return new ResponseEntity<>("Company doesn't exists",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/review/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
		Review review = reviewService.getReviewById(reviewId);
		if (review != null) {
			return new ResponseEntity<>(review,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/review/{reviewId}")
	public ResponseEntity<String> updateReviewById(@PathVariable Long reviewId,@RequestBody Review review){
		boolean temp = reviewService.updateById(reviewId,review);
		if (temp)
			return new ResponseEntity<> ("Review with id: "+reviewId+" has been succesfully updated",HttpStatus.OK);
		
		return new ResponseEntity<>("Review doesn't exists",HttpStatus.NOT_FOUND);	
		
	}
	
	@DeleteMapping("/review/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId){
		if (reviewService.deleteById(reviewId)) {
			return new ResponseEntity<> ("Review with id: "+reviewId+" has been succesfully deleted",HttpStatus.OK);
		}
		return new ResponseEntity<>("Company doesn't exists",HttpStatus.NOT_FOUND);	
	}
	
	
	
}	
