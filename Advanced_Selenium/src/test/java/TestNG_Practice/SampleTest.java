package TestNG_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SampleTest {

	@Test(priority=1)
	public void createProduct() {
		
		System.out.println("Product is created");
	}


	@Test(dependsOnMethods="createProduct", priority=-1)
	public void modifyProduct() {
		System.out.println("Product is modified");
	}

	//@Test(priority=0)
	@Test(dependsOnMethods={"createProduct","modifyProduct"}, priority=0)
	public void deleteProduct() {
		System.out.println("Product is deleted");
	}
}
