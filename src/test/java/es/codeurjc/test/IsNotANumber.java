package es.codeurjc.test;

import org.hamcrest.Description; 
import org.hamcrest.Factory; 
import org.hamcrest.Matcher; 
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher<Double> {
	
	
	
	public IsNotANumber() {
		
	}

@Override 
public boolean matchesSafely(Double number)
{ 
	return number.isNaN(); 
}

public final void describeTo(Description description) 
{ 
	description.appendText("not a number"); 
}

@Override
protected void describeMismatchSafely(final Double item, final
Description mismatchDescription) {
   mismatchDescription.appendText(" was ").appendValue(item.toString());
}

@Factory 
public static Matcher notANumber() 
{ 
	return new IsNotANumber(); 
}

}