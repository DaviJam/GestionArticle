package eu.ensup.domaine;

import com.sun.jdi.FloatType;

public class Article {
    private String name;
    private Integer quantity;
    private Float price;
    private String category;
    private String reference;

    public Article(String name, Integer quantity, Float price, String category, String reference) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
