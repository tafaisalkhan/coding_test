package com.company;

public class Main {
    static StringBuilder punctuation = new StringBuilder();

    public static void main(String[] args) {
        // write your code here
        String originalString = "Are you twenty-one years old?";
        System.out.println(originalString);
        System.out.println(reverseWords(originalString));
    }

    public static String reverseWords(String str) {
        // Split the string into words
        String[] words = str.split(" ");
        // Reverse each word and collect them into a StringBuilder
        StringBuilder reversedWords = new StringBuilder();
        for (int wordIndex = words.length - 1; wordIndex >= 0; wordIndex--) {
            int index = words[wordIndex].length() - 1;
            //check for punctuation
            while (index >= 0 && !Character.isLetterOrDigit(words[wordIndex].charAt(index))) {
                punctuation.append(words[wordIndex].charAt(index));
                index--;
            }
            if (!punctuation.toString().equalsIgnoreCase("")) {
                reversedWords.append(punctuation.toString() + words[wordIndex].toString().substring(0, words[wordIndex].length() - punctuation.toString().length()) + " ");
                punctuation = new StringBuilder();
            } else
                reversedWords.append(words[wordIndex] + " ");
        }
        return reversedWords.toString();
    }
}
