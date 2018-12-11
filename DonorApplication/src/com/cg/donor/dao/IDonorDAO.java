package com.cg.donor.dao;

import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;

public interface IDonorDAO 
{
	public String addDonor(DonorBean donor) throws DonorException;
	public DonorBean viewDonorDetails(String donorId)throws DonorException;
	public List retrieveAll()throws DonorException;
	
}
