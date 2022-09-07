package myapps.pojos;

public class PizzaPOJO {
    private String name;
    private String size;
    private float price;

    public PizzaPOJO() {

    }

    public PizzaPOJO(String name, String size, float price){
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PizzaPOJO{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
