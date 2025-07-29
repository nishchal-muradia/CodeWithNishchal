package DSA.TwoPointers;

/*LC 27. Remove Element
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are
not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted,
you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal
to val. The remaining elements of nums are not important as well as the size of nums.Return k.*/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0; // points to the next position for valid element

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j]; // overwrite
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 2, 3, 3, 3, 4, 4};
        int value = 2;
        int result = removeElement(nums, value);
        System.out.println(result);
    }
}
