package DSA.stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Handle closing brackets
            else {
                if (stack.isEmpty()) return false; // no opening bracket for this closing one
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty → all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "({[]})";   // ✅ valid
        String s2 = "({[})";    // ❌ invalid
        String s3 = "()[{}]";   // ✅ valid
        String s4 = "(";        // ❌ invalid

        System.out.println(s1 + " -> " + isValid(s1));
        System.out.println(s2 + " -> " + isValid(s2));
        System.out.println(s3 + " -> " + isValid(s3));
        System.out.println(s4 + " -> " + isValid(s4));
    }
}