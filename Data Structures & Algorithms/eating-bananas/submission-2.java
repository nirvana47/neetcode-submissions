class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // BINARY SEARCH METHOD

        // we get the max bananas in a pile, which will be the max value for `k`
        int maxBananaPile = 0;
        for (int index = 0; index < piles.length; index++) {
            if (maxBananaPile < piles[index])
                maxBananaPile = piles[index];
        }

        int left = 1;
        int right = maxBananaPile;
        int k = 1;
        // int result = right;

        while (left <= right) {
            k = left + (right - left) / 2;
            if (kongCanEat(piles, h, k)) {
                // if (k < result) result = k;
                right = k - 1; // let's see if we can find an even smaller value for k
            } else {
                left = k + 1; // could not do it at k rate, lets find a higher rate.
            }
        }
        return left;

        /*
            BRUTE FORCE METHOD
        */

        // Arrays.sort(piles);
        // int k = 1; // 1 banana per hour
        // int x = 0; // total # of hours reqd. to finish the bananas in piles

        // while (true) {
        //     for (int i = piles.length - 1; i >= 0; i--) {
        //         x += ((long) piles[i] + k - 1) / k;
        //         if (x > h) {
        //             break;
        //         }
        //     }
        //     if (x > h) {
        //         x = 0;
        //         k++;
        //     } else {
        //         break;
        //     }
        // }

        // return k;
    }

    private boolean kongCanEat(int[] piles, int h, int k) {
        int x = 0; // total # of hours reqd. to finish the bananas in piles
        for (int i = 0; i < piles.length; i++) {
            x += ((long) piles[i] + k - 1) / k;
            if (x > h) {
                return false;
            }
        }
        return true;
    }
}
