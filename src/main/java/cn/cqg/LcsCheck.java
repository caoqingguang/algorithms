package cn.cqg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoqingguang on 2016/12/22.
 */
public class LcsCheck {

  public static void main(String[] args) {
    String str1="abcdea";
    String str2="debcdefa";
    Map<String,String> cache = new HashMap<>();
    String result = calc(str1, str2, str1.length(), str2.length(), cache);
    System.out.println(String.format("最长公共序列为:[%s],公共长度:%s\n详情 字符串1:[%s] 和 字符串2:[%s] ",result,result.length(),str1,str2));
  }

  private static String calc(String str1, String str2, int index1, int index2, Map<String, String> cache) {
    if (index1 == 0 || index2 == 0) {
      return "";
    }
    char char1 = str1.charAt(index1 - 1);
    char char2 = str2.charAt(index2 - 1);
    if (char1 == char2) {
      return cache.computeIfAbsent(String.format("%s_%s", index1 - 1, index2 - 1), key -> calc(str1, str2, index1 - 1, index2 - 1, cache))+char1;
    }
    String case1 = cache.computeIfAbsent(String.format("%s_%s", index1 - 1, index2), key -> calc(str1, str2, index1 - 1, index2, cache));
    String case2 = cache.computeIfAbsent(String.format("%s_%s", index1, index2 - 1), key -> calc(str1, str2, index1, index2 - 1, cache));
    return case1.length() >= case2.length() ? case1 : case2;
  }

}
