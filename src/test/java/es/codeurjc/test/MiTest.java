package es.codeurjc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import es.codeurjc.test.IsNotANumber;


public class MiTest {
	IsNotANumber aux = new IsNotANumber();
	@Test
	public void testSquareRootOfMinusOneIsNotANumber()
	{ 
		assertThat(Math.sqrt(-1), IsNotANumber.notANumber()); 
	}
	
	@Test
	public void testSquareRootOfMinusOneIsNotANumber1()
	{ 
		assertThat("er", IsNotANumber.notANumber()); 
	}
}
