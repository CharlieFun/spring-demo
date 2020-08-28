package com.netease.spring.demo.algorithm;

/**
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree/solution/gen-ju-er-cha-shu-chuang-jian-zi-fu-chuan-by-leetc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author fangsida
 * @date 2020/8/28
 */
public class Leetcode606 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }


}
