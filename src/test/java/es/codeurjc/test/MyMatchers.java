package es.codeurjc.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.FeatureMatcher;
import es.codeurj.test.Alarm;

public class MyMatchers {
	public static Matcher<Alarm> isModule(final Alarm module) {
	    return new TypeSafeDiagnosingMatcher<Alarm>() {
	    	
	        public void describeTo(final Description description) {
	 	        description.appendText("Module should be ").appendValue(module.getModule());
	 	    }
	        
	 	    @Override
	 	    protected boolean matchesSafely(final Alarm item, final Description mismatchDescription) {
	 	        mismatchDescription.appendText("was").appendValue(item.getModule());
	 	        return module.getModule().equals(item.getModule());
	 	   }
	    };
    }
	 
	public static Matcher<Alarm> isActiveDescription(final Alarm activeDescription) {
	    return new TypeSafeMatcher<Alarm>() {
	    	
		    public void describeTo(final Description description) {		    	  
		        description.appendText("Active Description should be ").
		            appendValue(activeDescription.getActiveDescription());
		    }
		    
     	    @Override
		    protected boolean matchesSafely(final Alarm item) {
		        return activeDescription.getActiveDescription().equals(item.getActiveDescription());
		    }
		};
	}
	 
   public static Matcher<Alarm> isErrorCode(final int errorCodeAlarm) {
	   return new FeatureMatcher<Alarm, Integer>(Matchers.equalTo(errorCodeAlarm), 
			   "Error Code", "Error Code") {
	      @Override
	      protected Integer featureValueOf(final Alarm actual) {
	    	 return Integer.valueOf(actual.getErrorCode());
	      }
	   };
	}
}
