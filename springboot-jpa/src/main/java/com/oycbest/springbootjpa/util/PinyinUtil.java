package com.oycbest.springbootjpa.util;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/25 11:18 下午
 */

import java.util.*;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {

    /**
     *
     * 方法描述：根据输入的汉语获取拼音
     * <br />其中，本方法输出的拼音包括全拼和简拼，并且全拼和简拼都不重复
     * 方法名：getPinyin
     * 创建人：sjg
     * 创建时间：2013-4-18 下午9:16:47
     * @param str 要进行转化的汉字字符串
     * @return
     * 返回值：String
     */
    public static String getPinyin(String str){
        if (str == null || "".equals(str)) {
            return null;
        }
        List<Set<String>> pinyins = getPinyinStr(str);
        if (pinyins== null || pinyins.size()<1) {
            return null;
        }
        List<String> quanpin = getQuanpinResult(pinyins, null, 0);// 获取全拼
        Set<String> jianpin = getJianpinResult(pinyins, null, 0);// 获取简拼
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<quanpin.size();i++){
            if (i != quanpin.size()-1) {
                sb.append(quanpin.get(i) + ",");
            }else {
                sb.append(quanpin.get(i));
            }
        }
        /*Iterator<String> iterator = jianpin.iterator();
        while (iterator.hasNext()) {
           sb.append("," + iterator.next());
        }*/

        return sb.toString();
    }




    /**
     *
     * 方法描述：获取首字母简拼
     *      <br />为了防止重复，所以，使用set
     * 方法名：getJianpinResult
     * 创建人：sjg
     * 创建时间：2013-4-18 下午9:10:47
     * @param pinyins
     * @param curSet
     * @param index
     * @return
     * 返回值：Set<String>
     */
    public static Set<String> getJianpinResult(List<Set<String>> pinyins, Set<String> curSet, int index){
        if (pinyins == null || pinyins.size()<1) {
            return null;
        }
        Set<String> tempSet = new HashSet<String>();

        Set<String> pinyinSet = pinyins.get(index);
        if (curSet == null) {
            curSet = new HashSet<String>();
            for (String string : pinyinSet) {
                tempSet.add(string.charAt(0)+"");
            }
        }else {
            for (String oldPinyin : curSet) {
                for (String newPinyin : pinyinSet) {
                    tempSet.add(oldPinyin + newPinyin.charAt(0));
                }
            }
        }

        if (index == pinyins.size()-1) {
            return tempSet;
        }else {
            return getJianpinResult(pinyins, tempSet, ++index);
        }
    }




    /**
     *
     * 方法描述： 获取所有的全拼结果
     * 方法名：getQuanpinResult
     * 创建人：sjg
     * 创建时间：2013-4-18 下午8:56:17
     * @param pinyins
     * @param curList
     * @param index
     * @return
     * 返回值：List<String>
     */
    public static List<String> getQuanpinResult(List<Set<String>> pinyins, List<String> curList, int index){
        if (pinyins == null || pinyins.size()<1) {
            return null;
        }
        List<String> tempList = new ArrayList<String>();

        Set<String> pinyinSet = pinyins.get(index);
        if (curList == null) {
            curList = new ArrayList<String>();
            for (String string : pinyinSet) {
                tempList.add(string);
            }
        }else {
            for (String oldPinyin : curList) {
                for (String newPinyin : pinyinSet) {
                    tempList.add(oldPinyin + newPinyin );
                }
            }
        }

        if (index == pinyins.size()-1) {
            return tempList;
        }else {
            return getQuanpinResult(pinyins, tempList, ++index);
        }
    }




    /**
     *
     * 方法描述：获取这个字符串的所有的拼音的组合
     * 方法名：getPinyinStr
     * 创建人：sjg
     * 创建时间：2013-4-18 下午5:22:27
     * @param str
     * @return
     * 返回值：String
     */
    public static List<Set<String>> getPinyinStr(String str){
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        List<Set<String>> pinyinList = new ArrayList<Set<String>>();
        Set<String> pinyinsetSet = null;
        for (char c : chars) {// 获取所有的汉字的拼音
            pinyinsetSet = getCharacterPins(c);
            if (pinyinsetSet != null) {
                pinyinList.add(pinyinsetSet);
            }
        }

        return pinyinList;
    }


    /**
     *
     * 方法描述：获取单个字符的拼音
     *  <br/>由于我的需求是不要声调，相同读音的拼音便不要重复出现了，所以，选择使用set
     * 方法名：getCharacterPins
     * 创建人：sjg
     * 创建时间：2013-4-18 下午5:07:52
     * @param c
     * @return
     * 返回值：Set<String>
     */
    public static Set<String> getCharacterPins(char c){
        HanyuPinyinOutputFormat format = getFormat();
        String[] pinyins = null;
        try {
            // 获取拼音
            pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        Set<String> pinyinset = null;
        // 发生异常或者字符不是拼音的时候，pins都有可能是null，所以，必须进行判断
        if (pinyins != null) {
            pinyinset = new HashSet<String>();
            for (String pinyin : pinyins) {
                pinyinset.add(pinyin);
            }
        }

        return pinyinset;
    }


    /**
     *
     * 方法描述：获取HanyuPinyinOutputFormat的实例
     * 方法名：getFormat
     * 创建人：sjg
     * 创建时间：2013-4-18 下午5:06:11
     * @return
     * 返回值：HanyuPinyinOutputFormat
     */
    private static HanyuPinyinOutputFormat getFormat(){

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 声调不要
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        return format;
    }

    public static void main(String[] args) {
        System.out.println(getPinyin("李易峰"));
    }


}
