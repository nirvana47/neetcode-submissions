class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int arraySize = m * n;

        // converting a m x n matrix to 1-D array for binary search
        int left = 0;
        int right = arraySize - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > matrix[mid / n][mid % n]) {
                left = mid + 1;
            } else if (target < matrix[mid / n][mid % n]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixTwoLoops(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target > matrix[mid][0]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                return true;
            }
        }
        // bottom now has the row of the array where the target might reside.
        // so we run a binary search on that row.

        // if target < [0][0], then bottom will be -1. It will throw an error.
        if (bottom < 0) {
            return false;
        }

        int row = bottom; // this row is where we do the binary search now
        top = 0; // left
        bottom = matrix[top].length - 1; // right
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target > matrix[row][mid]) {
                top = mid + 1;
            } else if (target < matrix[row][mid]) {
                bottom = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
