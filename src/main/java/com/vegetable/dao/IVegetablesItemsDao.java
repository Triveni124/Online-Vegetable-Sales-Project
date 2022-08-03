package com.vegetable.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.NoVegetableFoundException;
import com.vegetable.exception.VegetableAlreadyExistException;
import com.vegetable.model.VegetablesItems;
import com.vegetable.repository.IVegetablesItemsRepository;
import com.vegetable.service.IVegetableMgmtService;
@Service
public class IVegetablesItemsDao implements IVegetableMgmtService{

	Logger logger=org.slf4j.LoggerFactory.getLogger(IVegetablesItemsDao.class);
	@Autowired
	IVegetablesItemsRepository vegrepos;
	@Override
	public VegetablesItems addVegetable(VegetablesItems veg)throws VegetableAlreadyExistException {
		
		if(vegrepos.existsById(veg.getVegetableId()))
		{
			logger.error("Vegetable already Exist");
			throw new VegetableAlreadyExistException("Vegetable already exists");
		}
		else
		{
			logger.info("Vegetable Added SuccessFully");
			return vegrepos.save(veg);
		}	
	}

	@Override
	public VegetablesItems updateVegetable(VegetablesItems veg)throws NoVegetableFoundException {
		
		if(vegrepos.existsById(veg.getVegetableId()))
	    {
			
			return vegrepos.save(veg);
		}
		else
		{
			throw new NoVegetableFoundException("vegetable does not exists");
		}
		
		
	}


	@Override
	public List<VegetablesItems> viewAllVegetables() {

		List<VegetablesItems> list = vegrepos.findAll();
		return list;
	}

	@Override
	public List<VegetablesItems> viewVegetableList(String category) {

		//List<VegetablesItems> list = vegrepos.findAll();
		return vegrepos.viewvegetableList(category);
	}

	@Override
	public List<VegetablesItems> viewVegetableByName(String name) {

		List<VegetablesItems> list = vegrepos.viewvegetableByName(name);
		return list;
	}

	@Override
	public void removeVegetable(int vegetableId) throws NoVegetableFoundException {
		
		 VegetablesItems veg = vegrepos.getById(vegetableId);
	        if(vegrepos.existsById(vegetableId))
	        {
	            vegrepos.delete(veg);
	        }
	}

	@Override
	public VegetablesItems getVegetableById(int vegetableId) {
		if(vegrepos.existsById(vegetableId))
        {
            Optional<VegetablesItems> opt = vegrepos.getVegetableById(vegetableId);
            VegetablesItems veg =opt.get();
            return veg;
        }
		return null;
	}

}
