package b_exception.usually_use;

public class IlleaglArgument {

        public static void main(String[] args) {
            setAge(-5);
            // 传入非法的年龄值，抛出 IllegalArgumentException
        }

        public static void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("年龄不能为负数");
            }
            System.out.println("年龄是: " + age);
        }
    }

