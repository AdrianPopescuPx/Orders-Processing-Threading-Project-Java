public class Product {
    private String productId;
    private String productOrder;

    public Product() {
    }

    public Product(String productId, String productOrder) {
        this.productId = productId;
        this.productOrder = productOrder;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(String productOrder) {
        this.productOrder = productOrder;
    }
}
