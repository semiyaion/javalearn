package b_exception.try_catch;

public class Test05 {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("捕获到异常: " + e.getMessage());
            e.printStackTrace();  // 打印原异常的堆栈信息
        }
    }

    public static void methodA() throws Exception {
        try {
            methodB();
        } catch (Exception e) {
            throw new Exception("从 methodA 捕获并抛出新异常", e);
        }
    }

    public static void methodB() throws Exception {
        throw new Exception("发生了异常");
    }
}
