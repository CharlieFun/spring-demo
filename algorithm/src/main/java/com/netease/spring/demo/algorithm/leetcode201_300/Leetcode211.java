package com.netease.spring.demo.algorithm.leetcode201_300;

/**
 * 前缀树
 * 参考：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/solution/c-qian-zhui-shu-hui-su-by-code_rain/
 * Leetcode208同类型题
 * @author fangsida
 * @date 2020/11/20
 */
public class Leetcode211 {

    static class WordDictionary {

        private boolean isEnd;

        private WordDictionary[] children;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            children = new WordDictionary[26];
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            WordDictionary dict = this;
            for (char ch : word.toCharArray()) {
                if (dict.getChildren()[ch - 'a'] == null) {
                    dict.getChildren()[ch - 'a'] = new WordDictionary();
                }
                dict = dict.getChildren()[ch - 'a'];
            }

            dict.setEnd(true);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return searchWord(this, word);
        }

        private boolean searchWord(WordDictionary dict, String word) {
            if (word.length() == 1) {
                if ('.' - word.charAt(0) == 0) {
                    for (int i = 0; i < 26; i++) {
                        if (dict.getChildren()[i] != null && dict.getChildren()[i].isEnd()) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    WordDictionary child = dict.getChildren()[word.charAt(0) - 'a'];
                    if (child != null && child.isEnd()) {
                        return true;
                    }
                    return false;
                }
            } else {
                if ('.' - word.charAt(0) == 0) {
                    for (int i = 0; i < 26; i++) {
                        if (dict.getChildren()[i] != null && searchWord(dict.getChildren()[i], word.substring(1))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    WordDictionary child = dict.getChildren()[word.charAt(0) - 'a'];
                    if (child != null && searchWord(child, word.substring(1))) {
                        return true;
                    }
                    return false;
                }
            }
        }


        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public WordDictionary[] getChildren() {
            return children;
        }

        public void setChildren(WordDictionary[] children) {
            this.children = children;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True


    }
}
