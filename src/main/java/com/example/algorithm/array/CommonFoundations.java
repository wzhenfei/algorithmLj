package com.example.algorithm.array;

import com.alibaba.fastjson.JSON;

/**
 * java常见基础算法，包括二分、排序...
 */
public class CommonFoundations {

    /**
     * 二分法 查找目标值在有序（升序）数组中的下标
     * @param arr 有序数组
     * @param tag 查找目标数
     * @return 下标
     */
    static int dichotomy(int[] arr, int tag){
        int start=0,end=arr.length-1,indexDefault=0;

        while (end>=start){
            //二分中间点
            int index=(start+end)>>1;
            int item=arr[index];
            if (item==tag){
                indexDefault=index;
                break;
            }
            //二分法的本质就是一步步缩小目标数所在的范围，中心下标所在值大于目标值说明目标值在起始点和中心点之间
            if (item>tag){
                end=index-1;
            }else {
                start=index+1;
            }
        }
        return indexDefault;
    }

    /**
     * 冒泡排序 将一个无序数组排序（升）
     * @param arr 无序数组
     * @return 数组
     */
    static int[] bubbleSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            //每一次循环将数组中最大的一个值通过不断地交换移动到数组的后面
            for (int j=i;j<arr.length-i-1;j++){
                //减i这里有无都可，减i更优，因为外层每次循环将最大值放到数组后面，数组的倒数i个数都是已经比较过的
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public static void main(String[] args) {
        //二分测试
        int[] arr=new int[]{1,3,5,6,7,9};
        System.out.println("二分：下标值"+dichotomy(arr,6));

        //冒泡
        int[] arrBubbleSort=new int[]{1,6,2,3,9,8};
        System.out.println("冒泡"+JSON.toJSONString(bubbleSort(arrBubbleSort)));
    }

}
