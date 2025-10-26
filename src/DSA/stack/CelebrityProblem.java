package DSA.stack;

import java.util.Stack;

public class CelebrityProblem {

    //Given a square matrix mat[][] of size n x n, where mat[i][j] == 1 means person i knows person j,
    // and mat[i][j] == 0 means person i does not know person j, find the celebrity person where,
    //A celebrity is defined as someone who:
    //Is known by everyone else
    //Does not know anyone (except themselves)
    //Return the index of the celebrity if one exists, otherwise return -1.

    // ✅ 1️⃣ Stack-based solution
    public static int findCelebrityUsingStack(int[][] mat, int n) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all people onto stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (stack.size() > 1) {
            int A = stack.pop();
            int B = stack.pop();

            if (mat[A][B] == 1) {
                // A knows B -> A cannot be celebrity
                stack.push(B);
            } else {
                // A doesn't know B -> B cannot be celebrity
                stack.push(A);
            }
        }

        // Step 3: Last person may be celebrity
        int candidate = stack.pop();

        // Step 4: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0)
                    return -1; // Not a celebrity
            }
        }

        return candidate;
    }

    // ✅ 2️⃣ Two-pointer (optimized) solution
    public static int findCelebrityUsingTwoPointer(int[][] mat, int n) {
        int candidate = 0;

        // Step 1: Find the potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                // candidate knows i -> candidate can't be celebrity
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0)
                    return -1; // Not a celebrity
            }
        }

        return candidate;
    }

    // ✅ Main method
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        int n = mat.length;

        int celebStack = findCelebrityUsingStack(mat, n);
        int celebTwoPointer = findCelebrityUsingTwoPointer(mat, n);

        System.out.println("Celebrity (Stack-based): " +
                (celebStack == -1 ? "No celebrity" : "Person " + celebStack));

        System.out.println("Celebrity (Two-pointer): " +
                (celebTwoPointer == -1 ? "No celebrity" : "Person " + celebTwoPointer));
    }
}
