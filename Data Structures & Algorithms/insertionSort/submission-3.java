// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> sortPairs = new ArrayList<List<Pair>>();

        for (int i = 0; i < pairs.size(); i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j + 1).key < pairs.get(j).key) {
                Pair tempPair = pairs.get(j + 1);
                pairs.set(j + 1, pairs.get(j));
                pairs.set(j, tempPair);
                j--;
            }
            sortPairs.add(new ArrayList<>(pairs));
        }
        return sortPairs;
    }
}
