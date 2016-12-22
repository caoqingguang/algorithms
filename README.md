# algorithms
算法相关
> **1.** [01背包问题](README.md#01背包问题)  <br>
> **2.** LCS最长公共序列



## 01 背包问题

**描述**：
```
三块石头  
A 重量 5  价值 20
B 重量 4  价值 10
C 重量 3  价值 12

背包容量 10，怎么装石头，背包价值最大？
```




计算**过程**和**结果**如下：

![](./rs/images/01bag.png)
```
最大价值：32, 负重：8 
详情：[A->{weight:5,price:20}, C->{weight:3,price:12}]
```


## LCS最长公共序列

计算过程见**code**，计算**结果**如下：
> 最长公共序列为:[bcdea],公共长度:5  <br>
> 详情 字符串1:<font size=5>[~~a~~***bcdea***]</font> 和 字符串2:<font size=5>[~~de~~***bcde***~~f~~***a***]</font> 