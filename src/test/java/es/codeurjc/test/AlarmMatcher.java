package es.codeurjc.test;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import es.codeurj.test.Alarm;
 
public class AlarmMatcher extends TypeSafeDiagnosingMatcher<Alarm> {
    private final Alarm expectedAlarm;
    private StringBuffer finalDescription = new StringBuffer("");
 
    public AlarmMatcher(Alarm expected) {
        this.expectedAlarm = expected;
    }
 
    @Override
    public boolean matchesSafely(Alarm actual, final Description mismatchDescription) {
    	boolean finalResult = true;
    	mismatchDescription.appendText("\n");
    	if (!MyMatchers.isModule(expectedAlarm).matches(actual)) {
    		finalResult = false;
    		finalDescription.append("\n").append(MyMatchers.isModule(expectedAlarm).toString());
    		mismatchDescription.appendText("Module is ").appendText(actual.getModule());
    	}
    	if (!MyMatchers.isActiveDescription(expectedAlarm).matches(actual)) {
    		finalResult = false;
    		finalDescription.append("\n").append(MyMatchers.isActiveDescription(expectedAlarm).toString());
    		mismatchDescription.appendText("\n").appendText("Active Description is ").appendText(actual.getActiveDescription());
    	}
    	if (!MyMatchers.isErrorCode(expectedAlarm.getErrorCode()).matches(actual)) {
    		finalResult = false;
    		finalDescription.append("\n").append(MyMatchers.isErrorCode(expectedAlarm.getErrorCode()).toString());
    		mismatchDescription.appendText("\n").appendText("Error Code is ").appendText(String.valueOf(actual.getErrorCode()));
    	}
    	return finalResult;
     }
 
    public void describeTo(Description descr) {
    	descr.appendText(finalDescription.toString()); 
    }
 
    @Factory
    public static AlarmMatcher alarmEqualTo(Alarm expected) {
        return new AlarmMatcher(expected);
    }

}
