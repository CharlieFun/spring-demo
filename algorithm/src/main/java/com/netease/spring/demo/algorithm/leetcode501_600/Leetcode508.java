package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *     作者：Geralt_U
 *     链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum/solution/508-chu-xian-ci-shu-zui-duo-de-zi-shu-yuan-su-he-b/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author fangsida
 * @date 2020/8/26
 */
public class Leetcode508 {

    HashMap<Integer,Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        findSum(root);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //计算左子树的和
        int left = findSum(root.left);
        //计算右子树的和
        int right = findSum(root.right);
        //计算当前子树的和
        int sum = root.val + left + right;
        //将结果放入HashMap中，并计算出出现的最多次数
        map.put(sum,map.getOrDefault(sum,0)+1);
        max = Math.max(max,map.get(sum));
        return sum;
    }


}
