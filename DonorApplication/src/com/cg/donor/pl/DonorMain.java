package com.cg.donor.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.service.DonorServiceImpl;
import com.cg.donor.service.IDonorService;

public class DonorMain 
{
	static Scanner sc=new Scanner(System.in);
	static IDonorService donorService=null;
	static DonorServiceImpl donorServiceImpl=null;
	public static void main(String[] args) 
	{
		DonorBean donorBean=null;
		String donorId=null;
		int option=0;
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("ICARE CAPGEMINI TRUST");
			System.out.println("______________________\n");
			
			System.out.println("1.Add Donator");
			System.out.println("2.View Donator");
			System.out.println("3.Retrieve All");
			System.out.println("4.Exit");
			System.out.println("_____________________");
			System.out.println("Select an option:");
			try
			{
				option=sc.nextInt();
				switch (option) {
				case 1:
					while(donorBean==null) {
						donorBean=populateDonorBean();
					}
					try
					{
						donorService=new DonorServiceImpl();
						donorId=donorService.addDonor(donorBean);
						System.out.println("donor id is:"+donorId);
					}
					catch(DonorException donorException)
					{
						System.err.println("ERROR :"+donorException.getMessage());
					}
					finally
					{
						donorId=null;
						donorService=null;
						donorBean=null;
					}
					break;
				case 2:
					
					break;
				case 3:
						
						break;
				case 4:
					
					break;
				default:
					break;
				}
			}
			catch(Exception e)
			{
				
			}
		}
	}
	private static DonorBean populateDonorBean() 
	{
		DonorBean donorBean = new DonorBean();
		System.out.println("Enter donor details:");
		
		System.out.println("Enter the donor name:");
		donorBean.setDonorName(sc.next());
		
		System.out.println("enter donor contact:");
		donorBean.setPhoneNumber(sc.next());
		
		System.out.println("Enter donor address:");
		donorBean.setAddress(sc.next());
		
		System.out.println("enter donation amount:");
		try
		{
		donorBean.setDonationAmount(sc.nextFloat());
		}
		catch(InputMismatchException ime)
		{
			sc.nextLine();
			System.err.println("Please enter a numeric value for donation amount,try again");
		}
		
		donorServiceImpl=new DonorServiceImpl();
		
		try
		{
			donorServiceImpl.validateDonor(donorBean);
			return donorBean;
		}
		catch(DonorException donorException)
		{
			System.err.println("invalid data:");
			System.err.println(donorException.getMessage()+"\n Try Again..");
			System.exit(0);
		}
		
		
		
		return null;
	}
}
















