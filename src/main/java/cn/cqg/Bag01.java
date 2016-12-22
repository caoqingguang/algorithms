package cn.cqg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caoqingguang on 2016/12/22.
 * 01背包问题
 */
public class Bag01 {

  public static void main(String[] args) {
    Stone[] stones = {new Stone("A", 5, 20), new Stone("B", 4, 10), new Stone("C", 3, 12)};
    Map<String,List<Stone>> cache = new HashMap<>();
    List<Stone> result = calc(stones, 3, 10, cache);
    int weight = 0;
    int price = 0;
    for (Stone stone : result) {
      weight += stone.weight;
      price += stone.price;
    }
    System.out.println(String.format("最大价值：%s, 负重：%s \n详情：%s", price, weight, result));

  }

  /**
   *
   * @param stones 备选集合
   * @param num 第几块
   * @param cap 容量
   * @param cache 缓存
   * @return  返回结果
   */
  private static List<Stone> calc(Stone[] stones, int num, int cap, Map<String,List<Stone>> cache){
    if(num==0||cap==0){
      return Collections.emptyList();
    }
    Stone stone = stones[num-1];
    List<Stone> case1=cache.computeIfAbsent(String.format("%s_%s",num-1,cap),key->calc(stones,num-1,cap,cache));
    if(cap<stone.weight){
      return case1;
    }
    List<Stone> case2=cache.computeIfAbsent(String.format("%s_%s",num-1,cap-stone.weight),key->calc(stones,num-1,cap-stone.weight,cache));
    int case1Price = case1.stream().mapToInt(s -> s.price).sum();
    int case2Price = case2.stream().mapToInt(s -> s.price).sum() + stone.price;
    if(case1Price>=case2Price){
      return case1;
    } else {
      List<Stone> result = new ArrayList<>(case2);
      result.add(stone);
      return result;
    }
  }

  private static class Stone{
    private final String name;
    private final int weight;
    private final int price;

    public Stone(String name, int weight, int price) {
      this.name = name;
      this.weight = weight;
      this.price = price;
    }

    @Override
    public String toString() {
      return String.format("%s->{weight:%s,price:%s}",name,weight,price);
    }
  }
}
