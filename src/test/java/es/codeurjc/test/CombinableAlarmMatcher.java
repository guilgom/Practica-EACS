package es.codeurjc.test;

import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class CombinableAlarmMatcher<T> extends TypeSafeDiagnosingMatcher<T> {
    private final List<Matcher<? super T>> matchers = new ArrayList<>();
    private final List<Matcher<? super T>> failedMatchers = new ArrayList<>();

    private CombinableAlarmMatcher(final Matcher<? super T> matcher) {
        matchers.add(matcher);
    }

    public CombinableAlarmMatcher<T> and(final Matcher<? super T> matcher) {
        matchers.add(matcher);
        return this;
    }

    @Override
    public boolean matchesSafely(final Object item, final Description mismatchDescription) {
    	
        boolean matchesAllMatchers = true;
        for (final Matcher<? super T> matcher : matchers) {
            if (!matcher.matches(item)) {
                failedMatchers.add(matcher);
                matchesAllMatchers = false;
            }
        }
        
        mismatchDescription.appendText("\n");
        for (Iterator<Matcher<? super T>> iterator = failedMatchers.iterator(); iterator.hasNext();) {
            final Matcher<? super T> matcher = iterator.next();
            mismatchDescription.appendText("Expected: <");
            mismatchDescription.appendDescriptionOf(matcher).appendText(" but ");
            matcher.describeMismatch(item, mismatchDescription);
            if (iterator.hasNext()) {
                mismatchDescription.appendText(">\n");
            }
        }
       
        
        return matchesAllMatchers;
    }

    public void describeTo(final Description description) {
        description.appendValueList("\n", " " + "and" + "\n", "", matchers);
    }

       
    public static <LHS> CombinableAlarmMatcher<LHS> all(final Matcher<? super LHS> matcher) {
        return new CombinableAlarmMatcher<LHS>(matcher);
    }
    
    
}
