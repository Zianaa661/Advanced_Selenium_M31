package TestNG_Practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	@Test
public void m1() {
	System.out.println("Step1");
	System.out.println("Step2");
	Assert.assertEquals(true, true); //Asssertion passed
	System.out.println("Step3");
	Assert.assertEquals(true, false); //Asssertion failed
	System.out.println("Step4");
	System.out.println("Step5");
}
	@Test
	public void m2() {
String expData="Qspiders";
String actData="Qspiders ";
Assert.assertEquals(expData, actData, "Assert Fail"); 
		System.out.println("Assert Pass");
		
	}
}
