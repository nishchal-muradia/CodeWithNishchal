package DSA.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSumExample {

    /**
     * Brute-force approach: check every pair.
     * Time: O(n^2), Space: O(1)
     */
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // return {-1,-1} if no solution (depends on requirement)
        return new int[]{-1, -1};
    }

    /**
     * Optimal approach using a HashMap to store value -> index.
     * Single pass. Time: O(n), Space: O(n)
     */
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // store current value and index
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // small helper to print result neatly
    private static void printResult(String label, int[] res) {
        if (res[0] == -1) {
            System.out.println(label + ": no solution found");
        } else {
            System.out.println(label + ": " + Arrays.toString(res));
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        printResult("Brute force ", twoSumBrute(nums1, target1));
        printResult("Optimal solution", twoSumHash(nums1, target1));

    }
}
