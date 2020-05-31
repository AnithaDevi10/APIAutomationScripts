package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CuCumberAnnotations {
	
	@Before
	public void init()
	{
		System.out.println("This is the first hook - before features");
		
	}
	
	@After
	public void tearDown()
	{
		System.out.println("This is the last hook - after all features");
	}

}
