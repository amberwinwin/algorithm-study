package hyy.demo.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1: 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2: 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * @author hyy
 * @version V2.0, 2020/1/22
 * @copyright
 */
public class UpdateMatrix {
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] distance = new int[row][col];
        Queue<Integer> list = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i);
                    list.add(j);
                }
            }
        }
        int x;
        int y;
        while (!list.isEmpty()) {
            x = list.poll();
            y = list.poll();
            if (y + 1 < col) {
                if (matrix[x][y + 1] != 0 && distance[x][y + 1] == 0) {
                    distance[x][y + 1] = distance[x][y] + 1;
                    list.add(x);
                    list.add(y + 1);
                }
            }
            if (y - 1 >= 0) {
                if (matrix[x][y - 1] != 0 && distance[x][y - 1] == 0) {
                    distance[x][y - 1] = distance[x][y] + 1;
                    list.add(x);
                    list.add(y - 1);
                }
            }
            if (x - 1 >= 0) {
                if (matrix[x - 1][y] != 0 && distance[x - 1][y] == 0) {
                    distance[x - 1][y] = distance[x][y] + 1;
                    list.add(x - 1);
                    list.add(y);
                }
            }
            if (x + 1 < row) {
                if (matrix[x + 1][y] != 0 && distance[x + 1][y] == 0) {
                    distance[x + 1][y] = distance[x][y] + 1;
                    list.add(x + 1);
                    list.add(y);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 0}};
        nums = updateMatrix(nums);
        System.out.println(nums);
    }
}
