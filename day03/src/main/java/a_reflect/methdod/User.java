package a_reflect.methdod;

import java.io.IOException;

public class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
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
    public void login(){
        System.out.println("登录");
    }
    private void  send(String name){
        System.out.println("发送消息");
    }
    private void send (String naem,Integer age)throws IOException,NullPointerException {
        System.out.println(name+"正在发送"+age);
    }
    protected void psd(){
        System.out.println("输入密码");
    }
}
