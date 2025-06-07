package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	int numOpen = 0;
    	int numClosed = 0;
    	Stack<String> brackets = new Stack<String>();
    	brackets.push(b);
    	while ( ! brackets.isEmpty()) {
    		String newPop = brackets.pop();
    		if(newPop.contains("{")) {
    			numOpen+= 1;
    		}else if (newPop.contains("}")) {
    			numClosed+= 1;
    		}
    	}
    	
        if(numOpen == numClosed) {
        	return true;
        }else {
        	return false;
        }
    }
}