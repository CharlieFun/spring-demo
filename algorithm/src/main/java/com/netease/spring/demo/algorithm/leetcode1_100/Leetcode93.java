package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/20
 */
public class Leetcode93 {

    List<List<String>> ipList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> track = new LinkedList<>();

        backTrack(s, 0, 3, track);

        List<String> ans = new ArrayList<>();
        for (List<String> ip : ipList) {
            ans.add(convert(ip));
        }

        return ans;
    }

    private String convert(List<String> ip) {
        return String.join(".",ip);
    }

    private void backTrack(String s, int startIndex, int count, LinkedList<String> track) {
        if (3 * (count + 1) < s.length() - startIndex) {
            return;
        }

        if (count == 0 && valid(s.substring(startIndex))) {
            track.add(s.substring(startIndex));
            ipList.add(new ArrayList<>(track));
            track.removeLast();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (startIndex + i > s.length()) {
                break;
            }

            String part = s.substring(startIndex, startIndex + i);
            if (valid(part)) {
                track.add(part);
                backTrack(s, startIndex + i, count - 1, track);
                track.removeLast();
            }
        }
    }

    private boolean valid(String str) {
        if (str.length() > 3 || str.length() == 0) {
            return false;
        }

        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }

        int val = Integer.valueOf(str);
        if (val > 255) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode93 ins = new Leetcode93();
        System.out.println(ins.restoreIpAddresses("010010"));
    }
}
