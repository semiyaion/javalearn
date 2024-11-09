package b_collection;

import java.util.HashSet;

public class HashSetDemo {
    /*Hashset
    * 其底层就是HashMap*/
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(null);
        //元素可以存放null但是不能重复
        //hashSet不能保证元素是否有序，取决于hash后，再确定索引的结果
        System.out.println(set.add("john"));
        System.out.println(set.add("lucy"));
        System.out.println(set.add("john"));
        //不可重复，返回flase
        System.out.println(set.add("jack"));
        System.out.println(set.add("rose"));
        set.remove("john");
        System.out.println(set);
        HashSet<Object> set01 = new HashSet<>();
        set01.add("lucy");
        set01.add(new Dog("Tom"));
        set01.add(new Dog("Tom"));
        //都可以添加成功
        System.out.println(set01);
        set01.add(new String("xlc"));
        set01.add(new String("xlc"));
        //第一个String建立俩个对象，第二个String建议一个对象
        System.out.println(set01);

        HashSet<Object> s = new HashSet<>();
        /*HashSet和HashMap去重原理
          1.先比较元素哈希值,再比较元素内容
          2.如果哈希值不一样,内容肯定不一样,存
          3.如果哈希值一样,再比较内容
          如果哈希值一样,内容不一样,存
          如果哈希值一样,内容也一样,去重复,后面的覆盖前面的*/


    }

    private static class Dog {
        private  String name;

        public Dog(String name) {
            this.name=name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
