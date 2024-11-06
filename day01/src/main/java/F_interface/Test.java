package F_interface;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("大黄","狗");
        dog.Swim();
        Fog fog = new Fog("大癞子", "青蛙");
        fog.Swim();
        System.out.println(dog);
        System.out.println(fog);
    }
}
