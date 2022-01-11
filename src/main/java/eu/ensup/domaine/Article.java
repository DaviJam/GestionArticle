package eu.ensup.domaine;

public class Article {
    private String name;
    private Integer quantity;
    private Float price;
    private String category;
    private String code;

    public Article(String name, Integer quantity, Float price, String category, String code) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", reference='" + code + '\'' +
                '}';
    }
}
