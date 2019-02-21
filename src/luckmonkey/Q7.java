package luckmonkey;

public class Q7 {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -1 * x;
        }
        int result=0;
        int divider = x / 10;
        int reminder = x % 10;

        while (divider != 0) {
            result = result * 10 + reminder;
            reminder = divider % 10;
            divider = divider / 10;
            if ((2147483647-reminder)/10 < result){
                return 0;
            }

        }
        result = result * 10 + reminder;
        if (negative) {
            result = -1 * result;
        }

        return result;
    }

    public static void main(String[] args) {
        Q7 q = new Q7();
        System.out.println(q.reverse(-2147483412));
    }
}
