package C_Cache_Pool;

public class Demo {
    public static void main(String[] args) {
        Integer x=new Integer(123);
        Integer y=new Integer(123);
        System.out.println(x==y);
        Integer a=Integer.valueOf(123);
        Integer b=Integer.valueOf(123);
        System.out.println(a==b);
        /**俩种构造有何不同，返回的bool值为什么不一样
         * 1.new Interger()使用时每次都会创建一个新的Interger对象，不会使用线程池，每次创建的地址都不相同，==比较的是地址值所以不一样
         * 2.Interger.valueof会将值放进缓冲池中，若创建新的对象会先查询缓冲池中是否存在相同数值，若存在则直接指向该地址名*/
        /**java8中的缓冲值数值在-128-127之间，若超出则判断为false*/
        Integer a1=325;
        Integer b1=325;
        System.out.println(a1==b1);
    }
}
