class Solution {
    // USING MIN HEAP

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[] {dist, point[0], point[1]});
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; ++i) {
            int[] point = minHeap.poll();
            result[i] = new int[] {point[1], point[2]};
        }
        return result;
    }

    // sort of brute-force N•Log(N) solution, where N is the # of points
    public int[][] bruteForcekClosest(int[][] points, int k) {
        /* * * MY IMPLEMENTATION
        int[][] distance = new int[points.length][2];

        for (int i = 0; i < points.length; i++) {
            distance[i][0] = distanceFromOrigin(points[i][0], points[i][1]);
            distance[i][1] = i;
        }

        // Arrays.sort(distance);
        Arrays.sort(distance, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int originalIndex = distance[i][1];
            result[i] = points[originalIndex];
        }

        return result;

        * * * */

        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    private int distanceFromOrigin(int x, int y) {
        // we are not doing sqrt since not needed for sake of comparison
        return (x * x + y * y);
    }
}
