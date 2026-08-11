class Solution {
    public void sortColors(int[] nums) {
        int[] colorCount = new int[3];

        for (int n : nums) {
            colorCount[n]++;
        }

        int numsIndex = 0;
        for (int colors = 0; colors < colorCount.length; colors++) {
            for (int c = 0; c < colorCount[colors]; c++) {
                nums[numsIndex] = colors;
                numsIndex++;
            }
        }
    }
}