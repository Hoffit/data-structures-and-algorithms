package repeatedword;

import hashtable.Hashtable;

public class RepeatedWord {

    private static Hashtable wordCountMap;

    private static char[] nonAlphaChars = new char[] {
            ' ',
            '.',
            '?',
            '!',
            ','
    };

    private static int indexOfNextWord;

    static String findFirstRepeatedWord(String words) {
        wordCountMap = new Hashtable();
        indexOfNextWord = 0;
        String nextWord = getNextWord(words);
        while (nextWord != null) {
            if (wordCountMap.contains(nextWord)) {
                return nextWord;
            }
            wordCountMap.add(nextWord.toLowerCase(), 1);
            nextWord = getNextWord(words.substring(indexOfNextWord));
        }
        return null;
    }

    private static String getNextWord(String words) {
        if (words.length() == 0) {
            return null;
        }
        int indexOfBreak = Integer.MAX_VALUE;
        int tempIndex;
        for (int i = 0; i < nonAlphaChars.length; i++) {
            tempIndex = words.indexOf(nonAlphaChars[i]);
            if (tempIndex == -1) {
                continue;
            }
            else if (indexOfBreak > tempIndex) {
                indexOfBreak = tempIndex;
            }
        }
        indexOfNextWord = indexOfNextWord + indexOfBreak;
        int offset = 0;
        boolean nextCharIsNotAlphaNumeric = true;
        while (nextCharIsNotAlphaNumeric) {
            indexOfNextWord++;
            offset++;
            char nextChar = words.charAt(indexOfBreak + offset);
            boolean foundNonAlpha = false;
            for (int i = 0; i < nonAlphaChars.length && !foundNonAlpha; i++) {
                if (nextChar == nonAlphaChars[i]) {
                    foundNonAlpha = true;
                }
            }
            if (foundNonAlpha) {
                continue;
            }
            nextCharIsNotAlphaNumeric = false;
        }
        return words.substring(0, indexOfBreak);
    }
}
