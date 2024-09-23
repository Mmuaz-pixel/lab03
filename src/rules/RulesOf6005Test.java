package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {

    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        
        // New test cases
        assertFalse("Expected false: cited code written as coursework",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
        
        assertTrue("Expected true: uncited external code available to all",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
        
        assertFalse("Expected false: code not available to others",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }
}
