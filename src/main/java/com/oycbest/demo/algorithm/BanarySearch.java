package com.oycbest.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: BanarySearch
 * @Description: BanarySearch
 * @Author oyc
 * @Date 2021/2/22 17:33
 * @Version 1.0
 */
public class BanarySearch {

    public static void main(String[] args) {
        System.out.println(BanarySearch.class.getName() + " test");
        int[] arr = new int[]{7, 9, 3, 12, 5, 6};
        ArrayList<Object> objects = new ArrayList<>();
        HashMap hashMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        System.out.println("binarySearch(arr,3) = " + binarySearch(arr, 6));

        System.out.println("bubbleSort(arr) = " + Arrays.asList( bubbleSort(arr)).toString());

        System.out.println("\nbubbleSort: " );
        Arrays.stream(bubbleSort(arr)).forEach(number -> System.out.print(number + " "));

        System.out.println("\ninsertSort:");
        Arrays.stream(insertSort(arr)).forEach(number -> System.out.print(number + " "));
    }

    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int heigh = array.length - 1;
        int mid;
        int count = 0;
        while (low <= heigh) {
            mid = (low + heigh) / 2;
            System.out.println("查找次数 count = " + (++count) + "   array[mid] = " + array[mid]);
            if (array[mid] == a) {
                return mid;
            }
            //向左查找
            if (array[mid] > a) {
                heigh = mid - 1;
            } else {//向右查找
                low = mid + 1;
            }
        }
        //找不到
        return -1;

    }

    public static int[] bubbleSort(int array[]) {
        //外层循环
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertSort(int array[]){
        for (int i = 1; i < array.length; i++) {
            //被插入的数
            int insertVal = array[i];
            //插入的位置
            int index = i-1;
            while(index >=0 && insertVal < array[index]){
                //数组中的数据往后移动
                array[index+1] = array[index];
                index--;
            }
            // 插入
            array[index+1]=insertVal;
        }

        return array;
    }
}
