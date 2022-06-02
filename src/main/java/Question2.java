import java.util.ArrayList;
import java.util.List;

public class Question2 {
    /**
     * remove cookies from box till empty, if n = 7, remove 1 or 3, how many ways can do that
     * 1.(1, 1, 1, 1, 1, 1, 1)
     * 2.(3, 1, 1, 1, 1)
     * 3.(1, 3, 1, 1, 1)
     * 4.(1, 1, 3, 1, 1)
     * 5.(1, 1, 1, 3, 1)
     * 6.(1, 1, 1, 1, 3)
     * 7.(1, 3, 3)
     * 8.(3, 1, 3)
     * 9.(3, 3, 1)
     */
    public static void main(String[] args) {
        System.out.println(Question2.way(7));
        /**
         * 1111111
         * 31111
         * 331
         */
        System.out.println(Question2.way(4));
        /**
         * 1111
         * 31
         */
        System.out.println(Question2.way(5));
        /**
         * 11111
         * 311
         */
        System.out.println(Question2.way(6));
        /**®
         * 111111
         * 3111
         * 33
         */
    }

    static int way(int n) {
        int c = 0;
        int possible_of_3 = n / 3;
        c++;

        for (int i = 1; i <= possible_of_3; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                tempList.add(3);
            }
            int r = n - 3 * i;
            boolean hasOne = false;
            while (r > 0) {
                tempList.add(1);
                r -= 1;
                if (!hasOne)
                    hasOne = true;
            }
            if (hasOne) {
                int size = tempList.size();
                c += size;
            } else {
                c++;
            }
        }

        return c;
    }
}
