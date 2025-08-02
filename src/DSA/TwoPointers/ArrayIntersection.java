package DSA.TwoPointers;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayIntersection {

    // 1. HashSet Approach
    public static int[] intersectionUsingHashSet(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) result.add(num);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // 2. Two Pointers Approach (requires sorting)
    public static int[] intersectionUsingTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> result = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(k -> k).toArray();
    }

    // 3. Binary Search Approach
    public static int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
        Arrays.sort(nums2); // sort one array
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // 4. Stream API Approach
    public static int[] intersectionUsingStreams(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        return Arrays.stream(nums2)
                .filter(set1::contains)
                .distinct()
                .toArray();
    }

    // 5. Brute Force Approach
    public static int[] intersectionUsingBruteForce(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    result.add(num1);
                    break;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // Main method to test all approaches
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println("1. HashSet Approach: " + Arrays.toString(intersectionUsingHashSet(nums1, nums2)));
        System.out.println("2. Two Pointers Approach: " + Arrays.toString(intersectionUsingTwoPointers(nums1, nums2)));
        System.out.println("3. Binary Search Approach: " + Arrays.toString(intersectionUsingBinarySearch(nums1, nums2)));
        System.out.println("4. Stream API Approach: " + Arrays.toString(intersectionUsingStreams(nums1, nums2)));
        System.out.println("5. Brute Force Approach: " + Arrays.toString(intersectionUsingBruteForce(nums1, nums2)));
    }
}
