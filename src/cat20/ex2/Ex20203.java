package cat20.ex2;

public class Ex20203 {
    /**
     * 为什么是N-sz,因为上个子数组就是sz, 那么右边剩余的子数组最大就是sz
     * sz=1
     * lo < 12-1=11
     * m0-1
     * m2-3
     * m4-5
     * m6-7
     * m7-8
     * m9-10
     * m11? : no
     * sz=2
     * lo < 10
     * m0-3
     * m4-7
     * m8-11
     * m12?: no
     * sz=4
     * lo < 12-4=8
     * m0-7
     * m8?: no
     * sz=8
     * lo <12-8=4
     * m0-(15,11): 得出结果
     */
}
