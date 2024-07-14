import java.util.Date;

public abstract class Insurance {
    protected String name;
    protected double price;
    protected Date startDate;
    protected Date endDate;

    public Insurance(String name, double price, Date startDate, Date endDate) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public abstract double calculate();
}
