class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        int ptr1 = 0, ptr2 = 0;

        for ( ; ptr2 < nums.length ; ptr2++ ) {
            if (nums[ptr2] != val) {
                nums[ptr1] = nums[ptr2];
                ptr1++;
            }
        }

        return (ptr1);
    }
}