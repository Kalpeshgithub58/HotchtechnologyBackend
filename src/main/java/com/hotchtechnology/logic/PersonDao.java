package com.hotchtechnology.logic;

import java.util.List;

import com.hotchtechnology.model.PersonModel;

public interface PersonDao {

	
	public boolean personCreate(PersonModel personModel);
	public boolean personUpdate(PersonModel personModel);
	public boolean personEdit(PersonModel personModel);
	public boolean personDelete(int personId);
	
	public List<PersonModel>getAllRecord();
	
	
}
