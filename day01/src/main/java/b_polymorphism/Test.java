package b_polymorphism;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<father> list = new ArrayList<>();
        /**新建集合，泛型中father表示只能存储fater类型的对象，意味着集合中每个元素都是father类型或者其子类*/
        list.add(new child01());
        /**集合中添加重写的方法*/
        list.add(new child02());
        list.add(new father());
        for (father father : list) {
            father.play();/**增强for遍历list集合，list中存储的都是father及其子类所以可直接调用对应的play方法*/
            /**方法的重写不会改变父类中的数据*/
        }
        /**向上转型*/
        father father02 = new child01();
        father02.play();
        father02.run();
        /**fateher 只能使用父类中的方法，若子类中重写了父类中的方法，则输出的是子类方法，但子类中只能使用父类中的方法，不能使用自己的方法*/


        /**如果一定要使用则，父类乡下转型为子类*/
        child01 fat=(child01) father02;
        fat.cs();


    }

}
