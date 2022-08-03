package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dao.IVegetablesItemsDao;
import com.vegetable.exception.NoVegetableFoundException;
import com.vegetable.exception.VegetableAlreadyExistException;
import com.vegetable.model.VegetablesItems;

@RestController
@CrossOrigin("http://localhost:4200/")
public class IVegetablesItemsController {

	@Autowired
	private IVegetablesItemsDao dao;
	
	@PostMapping(path="/addVegetable")
	public VegetablesItems addVegetable(@RequestBody VegetablesItems veg) throws VegetableAlreadyExistException
	{
		return dao.addVegetable(veg);
	}

	
	@PutMapping(path="/updateVegetable")
	public VegetablesItems updateVegetable(@RequestBody VegetablesItems veg) throws NoVegetableFoundException
	{
		return dao.updateVegetable(veg);
		
	}
	
	@GetMapping(path="/getVegetableId/{vegetableId}")
    public VegetablesItems getVegetableById(@PathVariable int vegetableId)
    {
        return dao.getVegetableById(vegetableId);
        
    }
	
	@GetMapping(path = "/viewAllvegetable")
	public List<VegetablesItems> viewAllvegetables()
	{
		return dao.viewAllVegetables();
	}
	
	
	@GetMapping(path = "/viewvegetablesList/{category}")
	public List<VegetablesItems> viewvegetableList(@PathVariable String category) 
	{
		return dao.viewVegetableList(category);
	}
	@GetMapping(path="/viewvegetableByName/{name}")
	public List<VegetablesItems> viewvegetablelistByName(@PathVariable String name)
	{
		return dao.viewVegetableByName(name);
		
	}
	@DeleteMapping(path="/removeVegetable/{vegetableId}")
    public void removeVegetable(@PathVariable int vegetableId) throws NoVegetableFoundException
    {
        dao.removeVegetable(vegetableId);
        
    }
}
