package rules;

public class RulesOf6005 {

    public static boolean mayUseCodeInAssignment(boolean writtenByYourself,
            boolean availableToOthers, boolean writtenAsCourseWork,
            boolean citingYourSource, boolean implementationRequired) {
        
        // If the code is written by yourself (or your teammates in a group project), it's always allowed.
        if (writtenByYourself) {
            return true;
        }
        
        // If not written by yourself, check the conditions for using others' work.
        // You cannot use code from past coursework unless it meets specific criteria.
        if (!writtenByYourself) {
            // If the code is available to others, it might be reusable.
            // You must cite the source properly.
            if (availableToOthers) {
                // It can only be reused if it wasn't produced for coursework in this class.
                if (!writtenAsCourseWork) {
                    return citingYourSource; // Must cite the source
                } else {
                    return false; // Not allowed to reuse coursework
                }
            } else {
                // If the code is not available to others, it can't be used.
                return false;
            }
        }
        
        return false; // Default return (should not be reached)
    }
    
    public static void main(String[] args) {
        System.out.println("You may certainly use code you wrote yourself: " +
            RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        System.out.println("You may use others' code, available to all, with citation: " +
            RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
        System.out.println("You may NOT use past coursework: " +
            RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
}
