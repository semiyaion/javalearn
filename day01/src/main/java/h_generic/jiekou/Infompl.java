package h_generic.jiekou;

public class Infompl<T> implements Info<T>{
    private  T var;

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public T getVar() {
        return this.var;
    }

    public Infompl(T var) {
        this.var = var;
    }

    public Infompl() {
    }
}
