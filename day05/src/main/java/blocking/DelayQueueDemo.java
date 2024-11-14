package blocking;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    public static void main(String[] args) {
        //无界阻塞队列，这些元素只能在到期时候才能从队列中取走，是的DelayQueue成为实现时间基于优先级的调度服务
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
        delayeds.put(new DelayedElement(5000, "这是一个五秒后的元素"));
        try {
            System.out.println("取一个元素");
            Delayed take = delayeds.take();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class DelayedElement implements Delayed {
        private long delayUntil;
        private String message;

        public DelayedElement(long delayUntil, String message) {
            this.delayUntil = delayUntil;
            this.message = message;
        }

        public DelayedElement() {
        }

        public String getMessage() {
            return message;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayUntil - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.delayUntil, ((DelayedElement) o).delayUntil);
        }
    }
}
