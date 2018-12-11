package com.cg.donor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.dao.DonorDaoImpl;
import com.cg.donor.dao.IDonorDAO;
import com.cg.donor.exception.DonorException;

public class DonorServiceImpl implements IDonorService
{
	IDonorDAO donordao=new DonorDaoImpl();
	
	@Override
	public String addDonor(DonorBean donor) throws DonorException 
	{
		String donorSeq;
		donorSeq=donordao.addDonor(donor);
		return donorSeq;
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
	public void validateDonor(DonorBean bean)throws DonorException
	{
		List<String> validationErrors=new ArrayList<String>();
		if(!(isValidName(bean.getDonorName()))) {
			validationErrors.add("\n Donor name should be in alphabets and minimum 3 characters long!");
		}
		if(!(isValidAddress(bean.getAddress()))) {
			validationErrors.add("\n address should be greate than 5 characters");
		}
		if(!(isValidPhoneNumber(bean.getPhoneNumber()))) {
			validationErrors.add("\n phone number should be in 10 digit");
		}
		if(!(isValidAmount(bean.getDonationAmount()))) {
			validationErrors.add("\n amount should be in positive number");
		}
		if(!validationErrors.isEmpty())
			throw new DonorException(validationErrors+" ");
		
	}

	private boolean isValidAmount(double donationAmount)
	{
		return false;
	}

	private boolean isValidPhoneNumber(String phoneNumber) 
	{
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
	}

	private boolean isValidAddress(String address) 
	{
		return (address.length()>6);
	}

	private boolean isValidName(String donorName) 
	{
		Pattern namePattern =Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(donorName);
		return nameMatcher.matches();
	}
	public boolean validateDonorId(String donorId)
	{
		Pattern idPattern=Pattern.compile("[0-9]{1,4}");
		Matcher idMatcher=idPattern.matcher(donorId);
		if(idMatcher.matches())
			return true;
		else
		return false;
		
	}
	
	
	
}
