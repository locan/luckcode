package luckmonkey;

public class Q11 {
    public int maxArea(int[] height) {

        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int width = j - i;
                if (width <= 0) {
                    continue;
                }
                int temp = width * Math.min(height[i], height[j]);
                if (temp >= area) {
                    area = temp;
                }
            }
        }
        return area;
    }

    public int maxArea2(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.max((r - l) * Math.min(height[l], height[r]), area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Q11 q = new Q11();
        int res = q.maxArea2(a);
        System.out.println(res);
    }
}
