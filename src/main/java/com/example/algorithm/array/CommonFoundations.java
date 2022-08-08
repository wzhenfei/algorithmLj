package com.example.algorithm.array;

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


    public static void main(String[] args) {
        //二分测试
        int[] arr=new int[]{1,3,5,6,7,9};
        System.out.println("二分：下标值"+dichotomy(arr,6));
    }

}
