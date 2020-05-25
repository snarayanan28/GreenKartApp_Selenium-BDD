package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumberAutomation.Base;

public class Hooks extends Base	{
	@Before("@MobileTest")
	public void beforevaldiation()
	{
		System.out.println("Before Mobile  hook");
	}
	
	@After("@SmokeTest")
	public void Aftervaldiation()
	{
		driver.close();
	}
		
	@Before("@WebTest")
	public void beforeWebvaldiation()
	{
		System.out.println("Before Web  hook");
	}
		
	@After("@WebTest")
	public void AfterWebvaldiation()
	{
		System.out.println("  After Web after hook");
	}
	
	@After("@RegressionTest")
	public void AfterRegValdiation()
	{
		driver.close();
	}

}

