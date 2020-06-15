package org.wiulus.spring.cloud.commons.tools.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @version V1.0
 */
public class PinyinHelperUtil {

    private PinyinHelperUtil() {
    }

    /**
     * 得到中文首字母（中国 -> ZG）
     *
     * @param str 需要转化的中文字符串
     * @return 大写首字母缩写的字符串
     */
    public static String getPinYinHeadChar(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString().toUpperCase().substring(0, 1);
    }


    /**
     * 得到英文全拼
     *
     * @param str: 字符
     * @return 小写英文全拼
     * @Date 2019/12/16 10:00
     * @author m13886933623@163.com
     **/
    public static String getPinYinAllChar(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                String s = pinyinArray[0];
                convert.append(s.substring(0, s.length() - 1));
            } else {
                convert.append(word);
            }
        }
        return convert.toString();
    }

    /**
     * 获取所有字符首字母的接口
     *
     * @param str: 字符
     * @return 字符首字母
     * @Date 2019/12/16 10:00
     * @author m13886933623@163.com
     **/
    public static String getPinYinAllHeadChar(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        if (convert.toString().length() > 0) {
            return convert.toString().toUpperCase();
        } else {
            return "";
        }
    }
}
