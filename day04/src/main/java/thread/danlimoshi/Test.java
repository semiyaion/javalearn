package thread.danlimoshi;

public class Test {
    //饿汉式单例
    //可能会浪费空间
    private Test() {
    }

    private final static Test test = new Test();

    public static Test getInstance() {
        //得到系统当前已经实例化的该类对象，若当前系统还没有实例化过这个类的对象，则调用此类的构造函数
        return test;
    }


}
