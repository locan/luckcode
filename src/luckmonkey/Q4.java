/**
 * 寻找两个有序数组的中位数
 */

package luckmonkey;

public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numIndex1 = 0;
        int numIndex2 = 0;
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int[] combine = new int[num1Len + num2Len];
        int newIndex = 0;
        while (newIndex < (num1Len + num2Len)) {
            if (numIndex1 >= num1Len) {
                combine[newIndex] = nums2[numIndex2];
                ++numIndex2;
                ++newIndex;
                continue;
            }
            if (numIndex2 >= num2Len) {
                combine[newIndex] = nums1[numIndex1];
                ++numIndex1;
                ++newIndex;
                continue;
            }
            if (nums1[numIndex1] <= nums2[numIndex2]) {
                combine[newIndex] = nums1[numIndex1];
                ++numIndex1;
            } else {
                combine[newIndex] = nums2[numIndex2];
                ++numIndex2;
            }
            ++newIndex;
        }

        if (combine.length % 2 == 0) {
            int middle = combine.length / 2;
            double val = (combine[middle] + combine[middle -1]) / 2.0;
            return val;
        } else {
            int middle = combine.length / 2;
            double val = combine[middle] * 1.0;
            return val;
        }
    }

    public static void main(String[] args) {
        Q4 q = new Q4();
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2, 4};
        double res = q.findMedianSortedArrays(num1, num2);
        System.out.println(res);
    }
}
