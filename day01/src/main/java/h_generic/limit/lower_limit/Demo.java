package h_generic.limit.lower_limit;

public class Demo <T>{
    private T varchar;

    public T getVarchar() {
        return varchar;
    }

    public void setVarchar(T varchar) {
        this.varchar = varchar;
    }

    public Demo() {
    }

    public Demo(T varchar) {
        this.varchar = varchar;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "varchar=" + varchar +
                '}';
    }
}
