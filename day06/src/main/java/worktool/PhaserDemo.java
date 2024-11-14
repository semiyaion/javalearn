package worktool;

import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    /*提供了对动态数量线程的能力，即在多个前置线程运行的时候可以减少一个线程的使用，实现动态管理线程
     * 在构造方法中传入了任务总量parties之后还可以做任务总量的修改
     * party：一个party就是一个线程，也可以是个任务，在Phaser上注册一个party时，phaser会递增它的参与者数量
     * arrive：对应一个party状态，初始时是unarrived，调用arriveAndAwaitAdvance或者arriveAndDeregister进入arrive状态
     * 可以通过getUnarrivedParties获取当前未达到的数量
     * register：注册一个新的party到Phaser中
     * deRegister：减少一个party
     * phase：当所以注册的party都arrive'后，将调用Phaser的onAdvance方法来判断是否要进入下一阶段
     * arriveAndAwaitAdvance()表示一个方已到达当前阶段，并等待所有其他方到达。返回当前阶段号。当所有方到达时，会进入下一个阶段。
     * int arriveAndDeregister()表示一个方已到达当前阶段并立即注销（不再参与后续阶段的同步）。返回当前阶段号。
     * 终止：onAdvance*/

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3) {

        }
    }
}
