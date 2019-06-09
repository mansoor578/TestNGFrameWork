package FrameWork.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@BeforeSuite
	public void testsuite() {
		System.out.println("1. BeforeSuites");
		
	}
	
	@BeforeTest
	public void befforeTest() {
		System.out.println("2. BeforeTest");
	}
	//**************************************************************************
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("3. BeforeClass");
	}
	//**************************************************************************
	
	@BeforeMethod
	public void befroreMethod() {
		System.out.println("4. BeforeMethod");		
	}
	//**************************************************************************
	
	@Test 
	public void testCase() {
		System.out.println("5. Test ");		
	}
	//**************************************************************************
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("4. AfterMethod");		
	}
	//**************************************************************************

}
