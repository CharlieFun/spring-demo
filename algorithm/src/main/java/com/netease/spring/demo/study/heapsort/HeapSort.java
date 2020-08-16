package com.netease.spring.demo.study.heapsort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小堆
 *
 * @author fangsida
 * @date 2020/5/5
 */
public class HeapSort {

    /**
     * 上浮调整
     *
     * @param arr
     */
    public static void upAdjust(int[] arr) {
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp保存插入的待插入的叶子节点值，用于最后的赋值
        int temp = arr[childIndex];
        while (childIndex > 0 && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }

        arr[childIndex] = temp;
    }

    /**
     * 下沉调整
     *
     * @param arr         待调整堆
     * @param parentIndex 要下沉的父节点索引
     * @param len         堆的有效大小
     */
    public static void downAdjust(int[] arr, int parentIndex, int len) {
        int childIndex = parentIndex * 2 + 1;
        //temp保存待插入的父节点值，用于最后的赋值
        int temp = arr[parentIndex];
        while (childIndex < len) {
            if (childIndex + 1 < len && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }

            if (temp <= arr[childIndex]) {
                break;
            }

            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }

        arr[parentIndex] = temp;
    }

    /**
     * 构建堆
     *
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            downAdjust(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((k1,k2) -> k2-k1);
        for (int i : arr) {
            queue.offer(i);
        }
        int[] res = new int[9];
        int j = 0;
        while (!queue.isEmpty()) {
            res[j++] = queue.poll();
        }
        System.out.println(Arrays.toString(res));

    }



}
