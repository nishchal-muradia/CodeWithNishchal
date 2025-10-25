package DSA.Array;

public class MissingNumberL268 {

    //Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumberL268 s = new MissingNumberL268();
        int[] nums = {3, 0, 1};
        System.out.println("Missing Number: " + s.missingNumber(nums));
    }

}


