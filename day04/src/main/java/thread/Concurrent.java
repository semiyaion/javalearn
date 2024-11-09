package thread;

public class Concurrent {
    public static void main(String[] args) {
        /*线程的六种状态：
            新建
            可运行
            阻塞
            无限期等待
            限期等待
            死亡
                       ------synchronized  Lock------→阻塞-------
                       ↓                                        ↓
            新建线程——>可运行<----sleep-------->限时等待---------->死亡
                        ↑                                       ↑
                         ------wait，notify------>无线等待--------

            并发进程：在同一时刻，有多个指令在单个cpu上交替运行
            并行：在同一时刻，有多个指令在多个cpu上同时运行*/

        /*多线程实现方法
         * 1.Runnable接口，Callable接口，tread类*/

    }
}
