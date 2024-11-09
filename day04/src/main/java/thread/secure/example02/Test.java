package thread.secure.example02;

public class Test {
    public static void main(String[] args) {
        Account xlc = new Account("xlc", 1666666.6);
        Thread t1 = new Thread(new Withdraw(xlc));
        Thread t2 = new Thread(new Withdraw(xlc));
        t1.start();
        t2.start();
    }
}

class Withdraw implements Runnable {
    private Account act;

    public Withdraw(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        try {
            act.withdraw(1598);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Account {
    private String actNo;
    private Double blace;

    public Account() {
    }

    public Account(String actNo, Double blace) {
        this.actNo = actNo;
        this.blace = blace;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public Double getBlace() {
        return blace;
    }

    public void setBlace(Double blace) {
        this.blace = blace;
    }

    public void withdraw(double money) throws InterruptedException {
        synchronized (Test.class) {
            double cash = this.getBlace();
            System.out.println("取款前" + Thread.currentThread().getName() + "......" + this.getBlace());
            this.setBlace(cash - money);
            Thread.sleep(3000);
            System.out.println("取款后" + Thread.currentThread().getName() + "......." + this.getBlace());
            Thread.sleep(2000);
        }

    }
}
