package com.vegetable.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.FeedbackFoundException;
import com.vegetable.exception.NoCustomerIdExistException;
import com.vegetable.exception.NoVegetableIdFound;
import com.vegetable.model.FeedBack;
import com.vegetable.repository.IfeedbackRepository;
import com.vegetable.service.IFeedbackService;
@Service
public class IFeedbackDao implements IFeedbackService{

	@Autowired
	private IfeedbackRepository feedrepository;
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(IFeedbackDao.class);
	@Override
	public FeedBack addFeedback(FeedBack feed)throws FeedbackFoundException {

		if(feedrepository.existsById(feed.getFeedbackId())) {
			logger.error("Feedback already submitted");
			throw new FeedbackFoundException("Feedback already done");
		}
		else {
			logger.info("Feedback Added");
			return feedrepository.save(feed);
		}
}

	@Override
	public List<FeedBack> viewAllFeedbacks(int vegetableId)throws NoVegetableIdFound {
   List<FeedBack> list=feedrepository.viewFeedback(vegetableId);
   for(FeedBack f:list) {
	   logger.info(f.getComments()+" "+f.getRating());
	   
   }
   return list;
	}

	@Override
	public List<FeedBack> viewFeedback(int customerId)throws NoCustomerIdExistException {

		List<FeedBack>list=feedrepository.viewAllFeedback(customerId);
		logger.info("Feedback viewd");
		return list;
		
	}

	

}
