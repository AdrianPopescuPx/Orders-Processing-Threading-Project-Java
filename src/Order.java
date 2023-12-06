public class Order {
    private String id;
    private Integer numberOfProducts;

    public Order() {
    }

    public Order(String id, Integer numberOfProducts) {
        this.id = id;
        this.numberOfProducts = numberOfProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }
}
