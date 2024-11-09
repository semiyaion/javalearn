package thread.setpripriority;

public class Pripriority {
    public static void main(String[] args) {
        /*抢占式调度：那条线程抢到就算谁的，随机新，优先度越大抢到概率越大
        setPriority：设置线程优先级
        getPriority:获取线程优先级
            非抢占式调度：每条线程以此执行一次*/
        Mine mr = new Mine();
        Thread th1 = new Thread(mr, "线程一");
        Thread th2 = new Thread(mr, "线程二");
        //若没有给线程设置优先级为5
        //优先级越高，抢到线程的概率就越高
        th1.setPriority(1);
        th2.setPriority(10);
        th1.start();
        th2.start();
        System.out.println(th1.getPriority());

    }
}
