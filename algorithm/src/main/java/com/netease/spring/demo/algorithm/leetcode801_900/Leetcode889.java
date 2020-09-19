package com.netease.spring.demo.algorithm.leetcode801_900;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.Arrays;

/**
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solution/gen-ju-qian-xu-he-hou-xu-bian-li-gou-zao-er-cha-sh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author fangsida
 * @date 2020/9/18
 */
public class Leetcode889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) {
            return root;
        }

        int L = 0;
        for (int i = 0; i < N; ++i) {
            if (post[i] == pre[1]) {
                L = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),
                Arrays.copyOfRange(post, L, N - 1));
        return root;
    }

}
