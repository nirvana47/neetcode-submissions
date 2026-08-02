class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] stuCount = new int[2];

        // Step 1: Count preference totals (stuCount[0] for 0s, stuCount[1] for 1s)
        for (int student : students) {
            stuCount[student]++;
        }

        // Step 2: Iterate through sandwiches and serve students
        for (int sandwich : sandwiches) {
            // If no students left who want this sandwich type, stop
            if (stuCount[sandwich] == 0) {
                break;
            }
            // Serve the sandwich
            stuCount[sandwich]--;
        }

        // Remaining students who couldn't eat
        return stuCount[0] + stuCount[1];
    }
}