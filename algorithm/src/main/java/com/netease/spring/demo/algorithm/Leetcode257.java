package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode257 {

    static String split = "->";

    List<String> res = new ArrayList<>();



    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> track = new LinkedList<>();
        backTrack(root, track);
        return res;
    }

    private void backTrack(TreeNode root, LinkedList<String> track) {
        if (root == null) {
            return;
        }

        track.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(convert(track));
        }

        backTrack(root.left, track);
        backTrack(root.right, track);
        track.removeLast();
    }

    private String convert(LinkedList<String> track) {
        return String.join(split, track);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(String.join(split, list));
    }
}
