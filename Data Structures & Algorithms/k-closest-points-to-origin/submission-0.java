class Solution {
    public int[][] kClosest(int[][] points, int k) {
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
    }

    private int distanceFromOrigin(int x, int y) {
        // we are not doing sqrt since not needed for sake of comparison
        return (x * x + y * y);
    }
}
