package hyy.demo.problem;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 0;
        int y = 0;
        int pos = 1;
        int total = n * n;
        int direct = 1;
        while (pos <= total) {
            matrix[x][y] = pos;
            pos++;
            if (direct == 1 && (y == n - 1 || matrix[x][y + 1] != 0)) {
                direct = -2;
                x++;
                continue;
            }
            if (direct == -2 && (x == n - 1 || matrix[x + 1][y] != 0)) {
                direct = -1;
                y--;
                continue;
            }
            if (direct == -1 && (y == 0 || matrix[x][y - 1] != 0)) {
                direct = 2;
                x--;
                continue;
            }
            if (direct == 2 && (x == 0 || matrix[x - 1][y] != 0)) {
                direct = 1;
                y++;
                continue;
            }
            if (direct == 1) {
                y++;
            } else if (direct == -1) {
                y--;
            } else if (direct == 2) {
                x--;
            } else {
                x++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
