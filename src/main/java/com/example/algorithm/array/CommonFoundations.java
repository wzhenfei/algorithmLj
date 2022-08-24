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

    /**
     * 选择排序 对于一个无序数组，每次找出来数组中没有排序的最小值，直到不存在没排序的元素
     * @param arr 无序数组
     * @return 数组
     */
    static int[] selectionSort(int[] arr){

        for (int i=0;i<arr.length;i++){
            //最小值下标
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //这里其实和冒泡排序思路差不多，都是目的将极值找出来放到最前面（冒泡放到后面），选择少了交换次数找到极值后才交换
            swap(arr,minIndex,i);
        }
        return arr;
    }

    /**
     * 插入排序 将数组分为有序和无序两部分，每次从无序部分拿出一个元素，放到有序里面该元素需要在有序部分找到自己的位置
     * @param arr 无序数组
     * @return 数组
     */
    static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tag=arr[i];
            //找出值在前面有序数组应该占得位置
            int index=i;
            for(int j=0;j<i;j++){
                if (arr[j]<tag && tag<arr[j+1]){
                    index=j+1;
                }
            }
            //找到tag要插入的index位置后，原先位置及其后方的元素的位置都得移动一位为它腾位置
            for (int j=i-1;j>=index;j--){
                arr[j+1]=arr[j];
            }
            arr[index]=tag;
        }
        return arr;
    }




    public static void main(String[] args) {
        //二分测试
        int[] arr=new int[]{1,3,5,6,7,9};
        System.out.println("二分：下标值"+dichotomy(arr,6));

        //冒泡
        int[] arrBubbleSort=new int[]{1,6,2,3,9,8};
        //System.out.println("冒泡"+JSON.toJSONString(bubbleSort(arrBubbleSort)));

        //选择
        //System.out.println("选择"+JSON.toJSONString(selectionSort(arrBubbleSort)));

        //插入
        System.out.println("插入"+JSON.toJSONString(insertionSort(arrBubbleSort)));

    }

}
