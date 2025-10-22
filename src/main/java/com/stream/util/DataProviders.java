package com.stream.util;

import org.testng.annotations.DataProvider;

import com.stream.driver.CommonStudio;

public class DataProviders extends CommonStudio {
	
	@DataProvider(name="loginCredentials")
	public Object[][] loginData() {
	        return new Object[][] {
	            {"tester1@simplestream.com", "TestLogin"},    
	            {"wrong@simplestream.com", "abc123"},         
	            {"test", "TestLogin"},                            
	            {"tester1@simplestream.com", "bc123"}             
	        };
	    }

}
