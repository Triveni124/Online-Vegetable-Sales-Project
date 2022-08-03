package com.vegetable;

import java.time.LocalDateTime;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.exception.AdminAlreadyExistException;
import com.vegetable.exception.AdminIdNotFoundException;
import com.vegetable.exception.BillAlreadyAdded;
import com.vegetable.exception.CartItemNotExistException;
import com.vegetable.exception.CartItemsExistException;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.ErrorInformation;
import com.vegetable.exception.FeedbackFoundException;
import com.vegetable.exception.NoAdminFoundException;
import com.vegetable.exception.NoBillFoundException;
import com.vegetable.exception.NoBillIdFoundException;
import com.vegetable.exception.NoCustomerIdExistException;
import com.vegetable.exception.NoIDFoundException;
import com.vegetable.exception.NoOrderDateFoundException;
import com.vegetable.exception.NoOrderFoundException;
import com.vegetable.exception.NoSuchCustomerException;
import com.vegetable.exception.NoVegetableFoundException;
import com.vegetable.exception.NoVegetableIdFound;
import com.vegetable.exception.OrderFoundException;
import com.vegetable.exception.VegetableAlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

	//Exception to handle CustomerAlreadyExistsException
	@ExceptionHandler(CustomerAlreadyExistsException.class)
       
	public @ResponseBody ErrorInformation CustomerAlreadyExistsExceptionInfo(CustomerAlreadyExistsException e,HttpServletRequest req) {
		 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	//Exception to handle NoSuchCustomerException
	
	@ExceptionHandler(NoSuchCustomerException.class)
	public @ResponseBody ErrorInformation NoSuchCustomerFoundExceptionInfo(NoSuchCustomerException e,HttpServletRequest req) {
		 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	//Exception to handle ResourceDBException
		@ExceptionHandler(com.vegetable.exception.ResourceDBException.class)
		public @ResponseBody ErrorInformation ResourceDBException(com.vegetable.exception.ResourceDBException e,HttpServletRequest req) {
			 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		//Exception to handle AdminAlreadyExistException
		@ExceptionHandler(AdminAlreadyExistException.class)
		public @ResponseBody ErrorInformation AdminAlreadyExistExceptionInfo(AdminAlreadyExistException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		//Exception to handle NoAdminFoundException
		@ExceptionHandler(NoAdminFoundException.class)
		public @ResponseBody ErrorInformation NoAdminFoundExceptionInfo(NoAdminFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		//Exception to handle AdminIdNotFoundException
		@ExceptionHandler(AdminIdNotFoundException.class)
		public @ResponseBody ErrorInformation AdminIdNotFoundExceptionInfo(AdminIdNotFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		//Exception to handle FeedbackFoundException
		@ExceptionHandler(FeedbackFoundException.class)
		public @ResponseBody ErrorInformation FeedbackFoundExceptionInfo(FeedbackFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(NoCustomerIdExistException.class)
		public @ResponseBody ErrorInformation NoCustomerIdExistExceptionInfo(NoCustomerIdExistException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		@ExceptionHandler(NoVegetableIdFound.class)
		public @ResponseBody ErrorInformation NoVegetableIdFoundInfo(NoVegetableIdFound e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		//Exception to handle VegetableItemsAlreadyExistException
		@ExceptionHandler(VegetableAlreadyExistException.class)
	       
		public @ResponseBody ErrorInformation VegetableAlreadyExistsExceptionInfo(VegetableAlreadyExistException e,HttpServletRequest req) {
			 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(NoVegetableFoundException.class)
		public @ResponseBody ErrorInformation NoSuchVegetableFoundExceptionInfo(NoVegetableFoundException e,HttpServletRequest req) 
		{
			 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(BillAlreadyAdded.class)
		public @ResponseBody ErrorInformation BillAlreadyAddedInfo(BillAlreadyAdded e, HttpServletRequest req) {
			 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(NoBillFoundException.class)
		public @ResponseBody ErrorInformation NoBillFoundExceptionInfo(NoBillFoundException e,HttpServletRequest req) {
			 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(NoBillIdFoundException.class)
		public @ResponseBody ErrorInformation NoBillIdFoundExceptionInfo(NoBillIdFoundException e,HttpServletRequest req) {
			 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(OrderFoundException.class)
		public @ResponseBody ErrorInformation OrderFoundExceptionInfo(OrderFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(NoOrderFoundException.class)
		public @ResponseBody ErrorInformation NoOrderFoundExceptionInfo(NoOrderFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		@ExceptionHandler(NoOrderDateFoundException.class)
		public @ResponseBody ErrorInformation NoOrderDateFoundExceptionInfo(NoOrderDateFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(CartItemsExistException.class)
		public @ResponseBody ErrorInformation CartItemsExistEceptionInfo(CartItemsExistException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		@ExceptionHandler(NoIDFoundException.class)
		public @ResponseBody ErrorInformation NoIDFoundExceptionnfo(NoIDFoundException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		@ExceptionHandler(CartItemNotExistException.class)
		public @ResponseBody ErrorInformation CartItemNotExistExceptionInfo(CartItemNotExistException e,HttpServletRequest req) {
			ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			 return erinfo;
		}
		
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public @ResponseBody ErrorInformation checkValidation(MethodArgumentNotValidException e,HttpServletRequest req) {
		
			 ErrorInformation erinfo = new ErrorInformation(e.getMessage(),req.getRequestURI(),LocalDateTime.now(), e.getBindingResult().toString());
			 System.out.println(e.getBindingResult().toString());
			 return erinfo;
		
			 
		}
		
}
