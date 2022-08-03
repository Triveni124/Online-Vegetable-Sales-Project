package com.vegetable.service;

import java.util.List;

import com.vegetable.exception.NoVegetableFoundException;
import com.vegetable.exception.VegetableAlreadyExistException;
import com.vegetable.model.VegetablesItems;

public interface IVegetableMgmtService {

	public VegetablesItems addVegetable(VegetablesItems veg)throws VegetableAlreadyExistException;
	public VegetablesItems updateVegetable(VegetablesItems veg)throws NoVegetableFoundException;
	public void removeVegetable(int vegetableId )throws NoVegetableFoundException;
	public List<VegetablesItems> viewAllVegetables();
	public List<VegetablesItems>viewVegetableList(String category);
	public List<VegetablesItems>viewVegetableByName(String name);
	public VegetablesItems getVegetableById(int vegetableId);
}
