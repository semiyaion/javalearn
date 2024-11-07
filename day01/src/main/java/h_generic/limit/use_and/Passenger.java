package h_generic.limit.use_and;

public class Passenger {
    Boolean isStangding;
    private Double salary;

    public Passenger(Boolean isStangding) {
        this.isStangding = isStangding;
    }

    public Passenger() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStanding() {
        return true;
    }
}
