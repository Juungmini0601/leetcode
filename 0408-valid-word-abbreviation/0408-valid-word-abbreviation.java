class Solution {
	public boolean validWordAbbreviation(String word, String abbr) {
		int wordCursor = 0;
		int abbrCursor = 0;
		int num = 0;

		while (wordCursor < word.length() && abbrCursor < abbr.length()) {
			if (Character.isDigit(abbr.charAt(abbrCursor))) {
				int digit = abbr.charAt(abbrCursor) - '0';

				if (num == 0 && digit == 0) {
					return false;
				}

				num = num * 10 + digit;
				abbrCursor++;
			} else {
				// 숫자만큼 wordCursor 이동
				wordCursor += num;

				if (wordCursor >= word.length()) {
					return false;
				}

				num = 0;
				if (word.charAt(wordCursor) != abbr.charAt(abbrCursor)) {
					return false;
				}

				wordCursor++;
				abbrCursor++;
			}
		}

		return wordCursor + num == word.length() && abbrCursor == abbr.length();
	}
}