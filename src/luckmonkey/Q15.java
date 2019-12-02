package luckmonkey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int numLen = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numLen; ++i) {
            for (int j = i + 1; j < numLen; ++j) {
                for (int z = j + 1; z < numLen; ++z) {
                    if ((nums[i] + nums[j] + nums[z]) == 0) {

                        if ((i - 1 >= 0 && (nums[i] == nums[i - 1]) || (j - 1 > i && (nums[j] == nums[j - 1])) || (z - 1 > j && nums[z] == nums[z - 1]))) {
                            continue;
                        }
                        if (result.size() > 0) {
                            List<Integer> lastRes = result.get(result.size() - 1);
                            if (lastRes.get(0) == nums[i] && lastRes.get(1) == nums[j] && lastRes.get(2) == nums[z]) {
                                continue;
                            }
                        }
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[z]);
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q15 q = new Q15();
        System.out.println(q.threeSum(new int[]{0, -4, -5, 3, 1, 3, 4, 2, -5, 2, 4, 2, -5}));
    }
}

class Q15_2 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int numLen = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int begin = 0;
        int end = numLen - 1;
        while (end - begin > 1) {
            
        }
        return result;
    }

}