package hyy.demo.problem;


/**
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 *
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,1],[2,3],[3,2]] 输出：true
 *
 * 提示：
 *
 * points.length == 3 points[i].length == 2 0 <= points[i][j] <= 100
 *
 * @author hyy
 * @version V2.0, 2019/11/26
 * @copyright
 */
public class IsBoomerang {

    public boolean isBoomerang(int[][] points) {
        if (points[0][0] == points[1][0] && points[1][0] == points[2][0]
            ||
            points[0][1] == points[1][1] && points[1][1] == points[2][1]) {
            return false;
        }
        if (Math.abs((points[1][1]-points[0][1])*(points[2][0]-points[1][0]))
            == Math.abs((points[2][1]-points[1][1])*(points[1][0]-points[0][0])) &&
            Math.abs((points[2][1]-points[0][1])*(points[2][0]-points[1][0]))
                == Math.abs((points[2][1]-points[1][1])*(points[2][0]-points[0][0]))
        ){
            return false;
        }
        return true;
    }
}
