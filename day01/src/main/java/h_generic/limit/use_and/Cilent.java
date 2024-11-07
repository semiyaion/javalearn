package h_generic.limit.use_and;

public class Cilent {
    //工资低于2500元的上班族且站立的乘客票打八折
    public static <T extends Passenger & Staff>void discount(T t){
        //泛型使用时前为要继承的类名，后年为要继承的接口
        t.setSalary(2600);
        if(t.getSalary()<2500 && t.isStanding()){
            System.out.println("车票打八折");
        }else {
            System.out.println("车票不打折");
        }
    }

    public static void main(String[] args) {
        discount(new Me());
    }

}
