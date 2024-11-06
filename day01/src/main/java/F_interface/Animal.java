package F_interface;

public class Animal {
    private String name;
    private  String sep;

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sep='" + sep + '\'' +
                '}';
    }

    public Animal(String name, String sep) {
        this.name = name;
        this.sep = sep;
    }
}
