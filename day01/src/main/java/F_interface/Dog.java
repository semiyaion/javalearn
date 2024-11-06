package F_interface;

public class Dog extends Animal implements Example{
    public Dog(String sep, String name) {
        super(sep,name);
    }

    @Override
    public void Swim() {
        System.out.println("狗刨");
    }
}
