class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (m == 0) {
      for (int i = 0; i < n; i++) {
        nums1[i] = nums2[i];
      }
    } else if (n > 0) {
      int nums1Index = m - 1;
      int nums2Index = n - 1;
      int comboIndex = m + n - 1;

      while (nums2Index >= 0 && nums1Index >= 0) {
        if (nums1[nums1Index] > nums2[nums2Index]) {
          nums1[comboIndex] = nums1[nums1Index];
          nums1Index--;
        } else {
          nums1[comboIndex] = nums2[nums2Index];
          nums2Index--;
        }
        comboIndex--;
      }
      while (nums1Index >= 0) {
        nums1[comboIndex--] = nums1[nums1Index--];
      }
      while (nums2Index >= 0) {
        nums1[comboIndex--] = nums2[nums2Index--];
      }
    }
  }
}
