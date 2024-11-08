package a_reflect.test_field;

public class User {
    public User() {
    }
    protected User(String name){
        this.name=name;
    }

    private String name;
    private Integer age;
    protected String pwd;
    public String id_name;

    public String getPwd() {
        return pwd;
    }

    public User(String name, Integer age, String pwd, String id_name) {
        this.name = name;
        this.age = age;
        this.pwd = pwd;
        this.id_name = id_name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getId_name() {
        return id_name;
    }

    public void setId_name(String id_name) {
        this.id_name = id_name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    private User(Integer age, String name){
        this.age=age;
        this.name=name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
