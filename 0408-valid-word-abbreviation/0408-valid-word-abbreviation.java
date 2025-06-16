class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wCursor = 0;
        int aCursor = 0;
        int num = 0;

        while (wCursor < word.length() && aCursor < abbr.length()) {
            // aCursor의 위치가 숫자인경우
            if (Character.isDigit(abbr.charAt(aCursor))) {
                int digit = abbr.charAt(aCursor) - '0';
                // 처음 나온 숫자가 0인 경우
                if (num == 0 && digit == 0) {
                    return false;
                }

                num = num * 10 + digit;
                aCursor++;
            } else {
                wCursor += num;
                // aCursor의 위치가 문자인 경우
                if (wCursor >= word.length()) {
                    return false;
                }

                if (abbr.charAt(aCursor) != word.charAt(wCursor)) {
                    return false;
                }

                wCursor++;
                aCursor++;
                num = 0;
            }
        }

        return wCursor + num == word.length() && aCursor == abbr.length();
    }
}