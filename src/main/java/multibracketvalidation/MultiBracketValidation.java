package multibracketvalidation;

import stacksandqueues.Stack;

public class MultiBracketValidation {

    public static boolean multiBracketValidation(String input) {

        if (input == null || input.length() == 0) {
            return true;
        }
        Stack stack = new Stack();
        char aChar;
        for (int i = 0; i < input.length(); i++) {
            aChar = input.charAt(i);
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(Character.toString(aChar));
            }
            else if (aChar == ')' || aChar == ']' || aChar == '}') {
                if ( (aChar == ')' && stack.peek().getValue().equals("(")) ||
                        (aChar == ']' && stack.peek().getValue().equals("[")) ||
                        (aChar == '}' && stack.peek().getValue().equals("{"))) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
