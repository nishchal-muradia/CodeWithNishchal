package DSA.stack;

import java.util.Stack;

/*Problem Recap
For each day, you have to find how many consecutive previous days (including today) had stock
 prices less than or equal to today’s price.

✅ Approach (Using Stack)
We’ll use a stack of indices to keep track of days with prices greater than current day’s price.
Logic:
        1. Iterate through the array.
        2. For each price:
        * Pop from stack while the current price ≥ price at top of stack.
        * If stack becomes empty → span = i + 1 (all days so far)
        * Else → span = i - stack.peek() (difference between current index and last higher price)
        3. Push current index onto stack.*/


public class StockSpanProblem {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // First day's span is always 1
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // Pop all elements smaller or equal to current price
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // If stack empty, all previous prices are smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push this element's index to stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = calculateSpan(prices);

        System.out.println("Stock Span Values:");
        for (int s : result) {
            System.out.print(s + " ");
        }
    }
}
