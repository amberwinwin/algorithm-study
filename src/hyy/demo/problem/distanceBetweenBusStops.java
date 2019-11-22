package hyy.demo.problem;

/**
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 1 输出：1 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 *
 * @author hyy
 * @version V2.0, 2019/11/21
 * @copyright
 */
public class distanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0;
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
        }
        if (start < destination) {
            for (int i = start; i < destination; i++) {
                sum += distance[i];
            }
        } else if (start > destination) {
            for (int i = destination; i < start; i++) {
                sum += distance[i];
            }
        } else {
            return 0;
        }
        return total - sum < sum ? total - sum : sum;
    }
}
