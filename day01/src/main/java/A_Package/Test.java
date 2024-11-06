package A_Package;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(12);
        person.setGender(0);
        person.setName("xlc");
        System.out.println(person.getName()+"  "+person.getGender()+"  "+person.getAge());
    }
    /**一.封装是什么？
     * 封装是使用抽象数据类型将一些数据以及使用数据的方法封闭在一个类中，外部数据不能使用，只能通过封装类中提供的外部接口来使提供联系
     * 外部程序无法随意修改对象状态，
     * 实现方法：private属性改为私有，只能在本类中修改*/
    /**二.为什么使用封装？
     * 1.增加模块的内聚性，减少耦合，更好的服务开发，测试与优化
     * 2.减少维护的负担，在调试或修改的过程中能较低的影响修改代码带来的维护性漏洞
     * 3.提高工作效率，类方法可直接导入其他模块
     * 4.数据保护，外部只能使用接口来间接访问，不能改变其内部数据*/
}
