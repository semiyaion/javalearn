package thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class TimerDemo {
    //定时器
    public static void main(String[] args) throws ParseException, InterruptedException {
        Timer timer = new Timer();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date date = sdf1.parse("2024-11-9 19:41:00");
        timer.schedule(new LogTimer(), date, 1000);
        //任务，开始时间，任务间隔

    }
}
