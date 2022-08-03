package com.vegetable.dao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.BillAlreadyAdded;
import com.vegetable.exception.NoBillFoundException;
import com.vegetable.exception.NoBillIdFoundException;
import com.vegetable.model.BillingDetails;
import com.vegetable.repository.IBillingRepository;
import com.vegetable.service.IBillingService;

@Service
public class IBillingDetailsDao implements IBillingService{

	Logger logger=org.slf4j.LoggerFactory.getLogger(IBillingDetailsDao.class);
	@Autowired
	private IBillingRepository billrepos;
	@Override
	public BillingDetails addBill(BillingDetails bill)throws BillAlreadyAdded {

		if(billrepos.existsById(bill.getBilliId())) {
			logger.error("Bill Exist Exception");
			throw new BillAlreadyAdded("Bill Alredy Exist");
		}
		else {
			logger.info("Bill added Successfully");
			return billrepos.save(bill);
		}
		
		
	}

	@Override
	public BillingDetails updateBill(BillingDetails bill)throws NoBillFoundException {
		if(billrepos.existsById(bill.getBilliId())) {
			logger.info("Bill Update Success");
			return billrepos.save(bill);
		}
		else {
			logger.error("No Existing Bill");
			throw new NoBillFoundException("No Bill Found For Update");
		}
		
	}

	@Override
	public BillingDetails viewBill(int id)throws NoBillIdFoundException {
		BillingDetails bill=billrepos.findById(id).get();
		return bill;
	}

	@Override
	public BillingDetails getBillingDetailsById(int billId) {
		if(billrepos.existsById(billId)) {
			java.util.Optional<BillingDetails> opt= billrepos.findById(billId);
			BillingDetails bill=opt.get();
			return bill;
		}
		return null;
	}

}
