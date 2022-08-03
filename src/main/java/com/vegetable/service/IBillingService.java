package com.vegetable.service;

import com.vegetable.exception.BillAlreadyAdded;
import com.vegetable.exception.NoBillFoundException;
import com.vegetable.exception.NoBillIdFoundException;
import com.vegetable.model.BillingDetails;

public interface IBillingService {

	public BillingDetails addBill(BillingDetails bill)throws BillAlreadyAdded;
	public BillingDetails updateBill(BillingDetails bill) throws NoBillFoundException;
	public BillingDetails viewBill(int id)throws NoBillIdFoundException;
	public BillingDetails  getBillingDetailsById(int billId);
}
