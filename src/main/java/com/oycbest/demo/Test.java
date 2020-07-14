package com.oycbest.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Administrator
 * @date: 2020/7/10 11:12
 */
public class Test {


    public int[] plusOne(int[] digits) {
        List<Integer> digistArr = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            digistArr.add(digits[i]);
        }
        List<Integer> integerList = new Test().format(digistArr);
        int[] digits1 = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            digits1[i] = integerList.get(i);
        }
        return digits1;
    }

    public List<Integer> format(List<Integer> digistArr) {
        int lastIndex = digistArr.size() - 1;
        if (digistArr.get(lastIndex) == 9) {
            if (lastIndex == 0) {
                return Arrays.asList(1, 0);
            } else {
                List<Integer> digistArrTemp = digistArr.subList(0, lastIndex);
                List<Integer> digistArrTemp1 = new ArrayList<>();
                List<Integer> digistArr1 = new ArrayList<>();
                digistArrTemp1 = format(digistArrTemp);
                digistArrTemp1.stream().forEach(s -> digistArr1.add(s));
                digistArr1.add(0);
                return digistArr1;
            }
        } else {
            digistArr.set(lastIndex, digistArr.get(lastIndex) + 1);
        }
        return digistArr;
    }

    public static void main(String[] args) {
        /*int[] digits = {9,9};
        int[] ints = new Test().plusOne(digits);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }*/
        System.out.println(SeaSonEnum.AUTUMN.getName());
        System.out.println(SeaSonEnum.AUTUMN.getValue());

        String test = "winter";
        SeaSonEnum sonEnum = SeaSonEnum.getByName(test);
        switch (sonEnum) {
            case SPRING:
                System.out.println("现在是 温暖春季 ：" + sonEnum.getValue());
                break;
            case SUMMER:
                System.out.println("现在是 炎炎夏日 ：" + sonEnum.getValue());
                break;
            case AUTUMN:
                System.out.println("现在是 悲凉秋季 ：" + sonEnum.getValue());
                break;
            case WINTER:
                System.out.println("现在是 寒冷冬季 ：" + sonEnum.getValue());
                break;
            default:
                System.out.println(test);
                break;
        }
    }
}
