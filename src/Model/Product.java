package Model;

public class Product {
    private int id;
    private int amount;
    private double priceP;
    private String nameP;
    private String describeP;

    public Product() {
    }

    public Product(int id, String nameP, int amount, double priceP, String describeP) {
        this.id = id;
        this.amount = amount;
        this.priceP = priceP;
        this.nameP = nameP;
        this.describeP = describeP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityP() {
        return amount;
    }

    public void setQuantityP(int amount) {
        this.amount = amount;
    }

    public double getPriceP() {
        return priceP;
    }

    public void setPriceP(double priceP) {
        this.priceP = priceP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getDescribeP() {
        return describeP;
    }

    public void setDescribeP(String describeP) {
        this.describeP = describeP;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", amount=" + amount +
                ", priceP=" + priceP +
                ", nameP='" + nameP + '\'' +
                ", describeP='" + describeP + '\'' +
                '}';
    }
}
