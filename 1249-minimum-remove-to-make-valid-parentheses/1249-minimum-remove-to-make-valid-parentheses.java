class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0;

        // First pass: remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
                sb.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(c);
                }
                // else skip this ')' because it's invalid
            } else {
                sb.append(c); // keep letters
            }
        }

        // Second pass: remove extra '(' from the end
        StringBuilder result = new StringBuilder();
        int balance = openCount; // number of unmatched '('
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && balance > 0) {
                balance--; // skip this '('
            } else {
                result.append(c);
            }
        }

        return result.reverse().toString();
    }
}
