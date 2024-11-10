package thread.danlimoshi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Lazy {
    private Lazy() {
        synchronized (Lazy.class) {
            if (lazy != null) {
                throw new RuntimeException("不能使用反射破坏");
            }
        }
    }

    private volatile static Lazy lazy;


    public synchronized static Lazy getInstance() {
        if (lazy == null) {
            //双重检测锁模式
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy();
                    //volatile的加入原因
                    /*懒汉式设计结构，其实是一个非原子性操作
                     * 在jvm中分为三步
                     * 1.分配内存空间
                     * 2.执行构造方法，实例化对象
                     * 3.将对象指向内存空间
                     *
                     * 标准执行顺序是123
                     * 但jvm在有时在保证效率的情况下在不改变代码结果的前提下会进行代码的重构132
                     * 在多线程执行时候，线程1完成了分配空间，指向空间，然后线程b开始执行判断，此时的lzey已经不为空直接return lazy
                     * 此时的lazy还没有完成构造*/
                }
            }

        }
        return lazy;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Lazy instance = Lazy.getInstance();
        System.out.println(instance);
        Lazy instance1 = Lazy.getInstance();
        System.out.println(instance1);
        //thread.danlimoshi.Lazy@1b6d3586
        //thread.danlimoshi.Lazy@1b6d3586

        //使用反射尝试
        Class<Lazy> lazyClass = Lazy.class;
        Constructor<Lazy> declaredConstructor = lazyClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Lazy lazy1 = declaredConstructor.newInstance();
        System.out.println(lazy1);
        //Caused by: java.lang.RuntimeException: 不能使用反射破坏
    }
}

