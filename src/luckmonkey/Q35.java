package luckmonkey;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class Q35 {

    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return i + 1;
    }
}
