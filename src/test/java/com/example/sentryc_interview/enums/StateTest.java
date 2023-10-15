package com.example.sentryc_interview.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StateTest {
    /**
     * Method under test: {@link State#valueOf(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValueOf() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.example.sentryc_interview.enums.State.Name
        //       at java.lang.Enum.valueOf(Enum.java:273)
        //       at com.example.sentryc_interview.enums.State.valueOf(State.java:3)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        State.valueOf("Name");
    }

    /**
     * Method under test: {@link State#valueOf(String)}
     */
    @Test
    void testValueOf2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        State.valueOf("BLACKLISTED");
    }

    /**
     * Method under test: {@link State#valueOf(String)}
     */
    @Test
    void testValueOf3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        State.valueOf("GREYLISTED");
    }

    /**
     * Method under test: {@link State#valueOf(String)}
     */
    @Test
    void testValueOf4() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        State.valueOf("REGULAR");
    }

    /**
     * Method under test: {@link State#valueOf(String)}
     */
    @Test
    void testValueOf5() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        State.valueOf("WHITELISTED");
    }

    /**
     * Method under test: {@link State#values()}
     */
    @Test
    void testValues() {
        State[] actualValuesResult = State.values();
        assertEquals(4, actualValuesResult.length);
        assertEquals(State.REGULAR, actualValuesResult[0]);
        assertEquals(State.WHITELISTED, actualValuesResult[1]);
        assertEquals(State.GREYLISTED, actualValuesResult[2]);
        assertEquals(State.BLACKLISTED, actualValuesResult[3]);
    }
}

