package demo.bookmanager.dto;

public class PhoneDto {
    private int phoneId;
    private String name;
    private String brand;
    private String color;
    private String capacity;
    private int price;
    private int stock;

    public PhoneDto(int phoneId, String name, String brand, String color, String capacity, int price, int stock) {
        this.phoneId = phoneId;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.capacity = capacity;
        this.price = price;
        this.stock = stock;
    }

    public PhoneDto(String name, String brand, String color, String capacity, int price, int stock) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.capacity = capacity;
        this.price = price;
        this.stock = stock;
    }

    public PhoneDto() {

    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "phoneId=" + phoneId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

}
