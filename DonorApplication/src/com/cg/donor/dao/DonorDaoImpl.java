package com.cg.donor.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.util.DBConnection;

public class DonorDaoImpl implements IDonorDAO 
{

	@Override
	public String addDonor(DonorBean donor) throws DonorException
	{
		try
		{
			Connection connection=DBConnection.getConnection();
		}
		catch (ClassNotFoundException | SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DonorBean viewDonorDetails(String donorId) throws DonorException
	{
		return null;
	}

	@Override
	public List retrieveAll() throws DonorException
	{
		return null;
	}

}
