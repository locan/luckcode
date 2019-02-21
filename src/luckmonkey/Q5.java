package luckmonkey;

public class Q5 {

    public String longestPalindrome(String s) {

        String ss = "";
        String temp = "";
        for (int begin = 0; begin < s.length(); begin++) {
            for (int end = s.length() - 1; end >= begin; end--) {
                if (s.charAt(begin) == s.charAt(end)) {
                    int i = begin;
                    int j = end;
                    if (begin - end + 1 < ss.length())
                        break;
                    boolean found = true;
                    while (i < j) {
                        if (s.charAt(i) != s.charAt(j)) {
                            found = false;
                            break;
                        }
                        i++;
                        j--;
                    }
                    if (found) {
                        temp = s.substring(begin, end + 1);
                        if (ss.length() < temp.length())
                            ss = temp;
                    }
                }
            }
        }

        return ss;
    }

    public static void main(String[] args) {
        Q5 q = new Q5();
        System.out.println(q.longestPalindrome("aaa"));

    }
}
