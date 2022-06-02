import java.util.Deque;
import java.util.LinkedList;

public class Question1 {
    /**
     * given a map =
     * [[S, 1, 0, X],
     * [1, 1, 0, 1],
     * [1, 1, 0, 1],
     * [1, 1, 1, 1],
     * [1, 1, 1, 1],
     * ]
     * find the minimum steps from S to X
     */

    public static void main(String[] args) {
        String[][] map = {{"S", "1", "0", "X"}, {"1", "1", "0", "1"}, {"1", "1", "0", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        System.out.println(Question1.steps(map));
    }

    static int steps(String[][] map) {
        Deque<Integer[]> q = new LinkedList<Integer[]>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int step = 0;
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        q.push(new Integer[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Integer[] c = q.pop();
            int x = c[0];
            int y = c[1];
            int originX = x;
            int originY = y;

            boolean isFindAdj = false;
            for (int[] m : moves) {
                x += m[0];
                y += m[1];

                try {
                    if ((x < 0 || x >= map.length) || (y < 0 || y >= map[0].length) || visited[x][y]) {
                        continue;
                    }
                    if (map[x][y].equals("X")) {
                        return ++step;
                    }
                    if (map[x][y].equals("1")) {
                        q.push(new Integer[]{x, y});
                        isFindAdj = true;
                        visited[x][y] = true;
                        System.out.println("X=" + x + ", Y=" + y);
                    }
                } finally {
                    x = originX;
                    y = originY;
                }
            }

            if (isFindAdj) {
                ++step;
                System.out.println("++step=" + step);
            }
        }
        return -1;
    }
}
