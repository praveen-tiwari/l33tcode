/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)



Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000

*/
class Solution {
    public class MyPoint {
        int x,y,dist;
        public MyPoint(int ax, int ay, int d) {
            x=ax;
            y=ay;
            dist=d;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<MyPoint> pq = new PriorityQueue<MyPoint>(K, new Comparator<MyPoint>() {
            public int compare(MyPoint a, MyPoint b) {
                return b.dist - a.dist;
            }
        });
        int i=0;
        for (; i<points.length; i++) {
            int x_idx = points[i][0];
            int y_idx = points[i][1];
            int dist = x_idx*x_idx + y_idx*y_idx;
            if (i<K)
                pq.add(new MyPoint(x_idx,y_idx, dist));
            else {
                MyPoint p = pq.peek();
                if (p.dist > dist) {
                    pq.poll();
                    pq.add(new MyPoint(x_idx, y_idx, dist));
                }
            }
        }

        int[][] res = new int[K][2];
        for (i=0; i<K; i++) {
            MyPoint p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }
}
