package E_Abstract;

public abstract class Example {
    protected int x;/**只允许同包中的类使用*/
    private  int y;
    public  abstract void mehtod();/**抽象方法一般在父类中不使用，适用于需求不明确的情况*，在子类中实现*/
    public void method2(){
        System.out.println("method2");
    }

    }

