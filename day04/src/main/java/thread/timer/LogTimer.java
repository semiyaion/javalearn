package thread.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class LogTimer extends TimerTask {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    int count;

    @Override
    public void run() {
        Date now = new Date();

        String s = sdf.format(now);
        System.out.println(s + "  " + count++);
    }
}
