package com.springIoC;

import org.springframework.beans.factory.annotation.Value;

public class CustomerDal implements ICustomerDal{

	@Value("${database.connectionString}")
	String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}



	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}



	@Override
	public void add() {
		System.out.println(connectionString);
		System.out.println("Oracle veritabanına kaydedildi");
		
	}

}
