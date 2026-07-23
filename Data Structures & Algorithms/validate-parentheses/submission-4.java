class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;

        char[] arrS = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (arrS[i] == '(' || arrS[i] == '{' || arrS[i] == '[') {
                stack.push(arrS[i]);
            } else if (arrS[i] == ')') {
                if (stack.isEmpty()) return false;
                if ('(' != stack.pop()) return false;
            } else if (arrS[i] == '}') {
                if (stack.isEmpty()) return false;
                if ('{' != stack.pop()) return false;
            } else if (arrS[i] == ']') {
                if (stack.isEmpty()) return false;
                if ('[' != stack.pop()) return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
