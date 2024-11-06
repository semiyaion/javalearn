package F_interface;

public class Fog extends Animal implements Example{
    @Override
    public void Swim() {
        System.out.println("蛙泳");
    }

    public Fog(String name, String sep) {
        super(name, sep);
    }
}
