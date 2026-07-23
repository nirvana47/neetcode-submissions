class Solution {
public boolean isValid(String s) {
    int n = s.length();
    if ((n & 1) == 1) return false; // odd length can't be balanced

    Deque<Character> st = new ArrayDeque<>(n);

    for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        switch (c) {
            case '(': st.push(')'); break;
            case '{': st.push('}'); break;
            case '[': st.push(']'); break;
            default:
                if (st.isEmpty() || st.pop() != c) return false;
        }
    }
    return st.isEmpty();
}

}
