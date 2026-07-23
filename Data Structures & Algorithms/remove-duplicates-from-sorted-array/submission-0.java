class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int ptr1 = 0, ptr2 = 1;

        for (; ptr2 < nums.length; ptr2++) {
            if (nums[ptr1] != nums[ptr2]) {
                ptr1 = ptr1 + 1;
            }
            nums[ptr1] = nums[ptr2];
        }
    return (ptr1+1);
    }
}