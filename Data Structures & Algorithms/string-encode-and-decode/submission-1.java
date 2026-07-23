class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty())
            return "";

        StringBuilder encodedSB = new StringBuilder();

        for (String s : strs) {
            if (s.isEmpty()) {
                encodedSB.append("0:");
            } else {
                encodedSB.append(s.length());
                encodedSB.append(":");
                encodedSB.append(s);
            }
        }

        String encodedStr = encodedSB.toString();
        return encodedStr;
    }

    public List<String> decode(String str) {
        if (str.isEmpty() || str.length() == 0)
            return new ArrayList<>();

        List<String> strList = new ArrayList<>();
        
        /* for (int i = 0; i < str.length();) {
            int strLen = str.charAt(i) - '0'; // convert the char to int
            strList.add(str.substring(i + 2, i + 2 + strLen));
            i = i + 2 + strLen;
        } */

        int i = 0;
        while (i < str.length()) {
            int textCursorPos = str.indexOf(":", i);
            int wordLen = Integer.parseInt(str.substring(i, textCursorPos));
            i = textCursorPos + 1;
            strList.add(str.substring(i, i + wordLen));
            i += wordLen;
        }

        return strList;
    }
}
