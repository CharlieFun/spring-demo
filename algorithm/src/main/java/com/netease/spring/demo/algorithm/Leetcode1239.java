package com.netease.spring.demo.algorithm;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode1;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/11/22
 */
public class Leetcode1239 {



    public static void main(String[] args) {
        Leetcode1239 ins = new Leetcode1239();
        List<String> arr = new ArrayList<>(Arrays.asList("zog", "nvwsuikgndmfexxgjtkb", "nxko"));
        System.out.println(ins.maxLength(arr));
    }

    int res = 0;

    public int maxLength(List<String> arr) {
        removeInvalidWord(arr);
        if (arr.size() == 0) {
            return 0;
        }

        dfs(arr, 0, 0, 0);
        return res;
    }

    private void dfs(List<String> list, int start, int bitMask, int len) {
        for (int i = start; i < list.size(); i++) {
            int bit = getBitMast(list.get(i));
            if (bit == 0 || (bit & bitMask) != 0) {
                continue;
            }

            bitMask = bitMask | bit;
            len += list.get(i).length();
            res = Math.max(res, len);
            dfs(list, i + 1, bitMask, len);
            len -= list.get(i).length();
            bitMask = bitMask ^ bit;
        }
    }

    private void removeInvalidWord(List<String> arr) {
        Iterator<String> iter = arr.iterator();
        while (iter.hasNext()) {
            if (getBitMast(iter.next()) == 0) {
                iter.remove();
            }
        }
    }

    private int getBitMast(String s) {
        int bitMask = 0;
        for (char ch : s.toCharArray()) {
            int bit = (1 << ch - 'a');
            if ((bitMask & bit) != 0) {
                return 0;
            }
            bitMask = bitMask | bit;
        }
        return bitMask;
    }

    /**
     * 自己的老算法，缺点：
     * 1.开辟空间太多
     * 2.没有用位运算提高速度
     */
    class Leetcode1239_old {
        int res = 0;

        Set<String> set = new HashSet<>();

        int[] dict = new int[26];


        public int maxLength(List<String> arr) {
            List<String> clearArr = clear(arr);
            if (clearArr.size() == 0) {
                return 0;
            }

            boolean[] visited = new boolean[clearArr.size()];
            dfs(clearArr, dict, visited);
            return res;
        }

        private List<String> clear(List<String> arr) {
            List<String> list = new ArrayList<>();
            for (String word : arr) {
                if (valid(word)) {
                    list.add(word);
                }
            }
            return list;
        }

        private boolean valid(String word) {
            boolean valid = true;
            for (char ch : word.toCharArray()) {
                dict[ch - 'a']++;
                if (dict[ch - 'a'] > 1) {
                    valid = false;
                    break;
                }
            }

            Arrays.fill(dict, 0);
            return valid;
        }

        private void dfs(List<String> arr, int[] dict, boolean[] visited) {
            String sDict = serialize(dict);
            if (set.contains(sDict)) {
                return;
            } else {
                set.add(sDict);
            }

            for (int i = 0; i < arr.size(); i++) {
                if (visited[i]) {
                    continue;
                }

                if (hasDuplicate(dict, arr.get(i))) {
                    continue;
                }
                visited[i] = true;
                addWord(dict, arr.get(i));
                res = Math.max(res, count(dict));
                dfs(arr, dict, visited);
                removeWord(dict, arr.get(i));
                visited[i] = false;
            }
        }

        private String serialize(int[] dict) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                builder.append(dict[i]);
            }
            return builder.toString();

        }

        private int count(int[] dict) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += dict[i];
            }
            return sum;
        }

        private boolean hasDuplicate(int[] dict, String s) {
            for (char ch : s.toCharArray()) {
                if (dict[ch - 'a'] > 0) {
                    return true;
                }
            }

            return false;
        }

        private void addWord(int[] dict, String s) {
            for (char ch : s.toCharArray()) {
                dict[ch - 'a']++;
            }
        }

        private void removeWord(int[] dict, String s) {
            for (char ch : s.toCharArray()) {
                dict[ch - 'a']--;
            }
        }
    }
}
