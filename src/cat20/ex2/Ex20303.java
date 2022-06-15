package cat20.ex2;

/**
 * Created by Wusd on 2022/5/31.
 * 对于长度为N的数组,在Quick.sort()执行时,最大的元素最多会被交换多少次
 * floor(N/2)
 * a为切分元素,b为最大值,每次新的排序都由abc... 变为 cadb...
 * 第二次切分为db... 变为eb...
 * 每次切分少了两个元素
 * 所以,最多进行了N/2次切分,交换了N/2次  
 **/
// 最大元素的交换次数为N/2
public class Ex20303 {
}
