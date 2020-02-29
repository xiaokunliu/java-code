package com.xiaokunliu.j2se.javase.stringTest;

/*
 *
 * 3，两个字符串中最大相同的子串。
 * 思路：
 * 1、先获取两个字符串的最小长度的那个字串
 * 2、先判断该最小字串是否完全包含在最大的字串中，如果
 * 不存在，则将该最小字串长度减少一个，分别在该字串中获得此时长度的字串，逐一判断是否包含在最大字串中
 * 3、重复2的工作直至获得最大相同的字串就停止搜索
 */
public class StringTest3 {

    public static void main(String[] args) {

        String str1 = "fhfhabcdefgabcdefgabcdefgdjjkj";
        String str2 = "wiabcdefgabcdefgabcdefgwi";

        String sameStr = getMaxSubString(str1, str2);
        System.out.println("sameStr=" + sameStr);
    }

    public static String getMaxSubString(String str1, String str2) {

        //先获得最大和最小字串
        String max = "", min = "";
        max = str1.length() > str2.length() ? str1 : str2;
        min = max.equals(str1) ? str2 : str1;

        for (int i = min.length(); i >= 1; i--) {
            for (int begin = 0, end = i; end < min.length() + 1; begin++, end++) {
                if (max.contains(min.substring(begin, end))) {
                    return min.substring(begin, end);
                }
            }
        }
        return null;
    }

    /**
     * 获取最大子串
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String getMaxSubstring(String s1, String s2) {

        String max = null, min = null;
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = max.equals(s1) ? s2 : s1;
//		System.out.println("max="+max);
//		System.out.println("min="+min);
        for (int i = 0; i < min.length(); i++) {

            for (int a = 0, b = min.length() - i; b != min.length() + 1; a++, b++) {

                String sub = min.substring(a, b);
//				System.out.println(sub);
                if (max.contains(sub))
                    return sub;
            }
        }

        return null;
    }
}
