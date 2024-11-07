package h_generic.limit.use_and;

public class Me extends Passenger implements Staff{
    private double salary;
    Boolean isStanding=true;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double salary() {
        return salary;
    }
}
